ARG BASE_IMAGE=icr.io/appcafe/websphere-liberty:kernel-java17-openj9-ubi
FROM $BASE_IMAGE

# Getting war files for utility applications
User root

RUN --mount=type=secret,id=token --mount=type=secret,id=user \
	  mkdir -p /mytemp && cd /mytemp && mkdir -p /opt/ibm/wlp/usr/shared/resources/db2drivers && mkdir -p /opt/ibm/wlp/usr/shared/resources/jaxrsThirdPartyJars \
      && chown -R 1001:0 /opt/ibm/wlp/usr/shared/resources/db2drivers \
      && chown -R 1001:0 /opt/ibm/wlp/usr/shared/resources/jaxrsThirdPartyJars \
      && curl --retry 7 -sSf -u $(cat /run/secrets/user):$(cat /run/secrets/token) \
      -O 'https://na.artifactory.swg-devops.com/artifactory/hyc-wassvt-team-maven-virtual/svtMessageApp/svtMessageApp/2.0.2/svtMessageApp-2.0.2.war' \
      && curl --retry 7 -sSf -u $(cat /run/secrets/user):$(cat /run/secrets/token) \
      -O 'https://na.artifactory.swg-devops.com/artifactory/hyc-wassvt-team-maven-virtual/microwebapp/microwebapp/2.0.1/microwebapp-2.0.1.war' \
      && curl --retry 7 -sSf -u $(cat /run/secrets/user):$(cat /run/secrets/token) \
      -O 'https://na.artifactory.swg-devops.com/artifactory/hyc-wassvt-team-maven-virtual/com/ibm/ws/lumberjack/badapp/2.0.1/badapp-2.0.1.war' \
      && chown -R 1001:0 /mytemp/*.war  && mv /mytemp/*.war /config/dropins
      
User 1001

# Copy config files
COPY  --chown=1001:0  ./GarageSaleLibertyEAR/target/GarageSaleLibertyEAR.ear /config/apps/
COPY  --chown=1001:0 ./GarageSaleRuntimeUtil/publish/servers/server-containers.xml /config/server.xml
COPY  --chown=1001:0  ./GarageSaleRuntimeUtil/publish/files/jvm.options /config/jvm.options
COPY  --chown=1001:0 ./GarageSaleRuntimeUtil/publish/servers/ldap-config.xml /config/configDropins/defaults/

#Copy DB2 and JaxRS Third Party libs
COPY  --chown=1001:0 ./GarageSaleRuntimeUtil/publish/databaseDrivers/db2V9Drivers /opt/ibm/wlp/usr/shared/resources/db2drivers/
COPY  --chown=1001:0 ./GarageSaleRuntimeUtil/publish/jaxrsThirdPartyJars /opt/ibm/wlp/usr/shared/resources/jaxrsThirdPartyJars/

#truststore for LDAP
COPY  --chown=1001:0  ./GarageSaleRuntimeUtil/publish/files/openldap.p12 /config/openldap.p12

#Copy GarageSale User feature to /mytemp folder
COPY --chown=1001:0 ./GarageSaleRuntimeUtil/publish/files/WASPersonaWebServicesHandlerFeature-1.0.0-SNAPSHOT.esa /mytemp

# Setting for the verbose option
ARG VERBOSE=true
ARG FULL_IMAGE=false
ARG OL=true

# This script will add the requested XML snippets to enable Liberty features and grow image to be fit-for-purpose using featureUtility. 
# Only available in 'kernel-slim'. The 'full' tag already includes all features for convenience.

#RUN if [[ -z "$FULL_IMAGE" ]] ; then echo Skip running features.sh for full image ; else  ; fi
RUN if [ "$FULL_IMAGE" = "false" ] && [ "$OL" == "true" ] ; then features.sh ; else echo "Skip running features.sh for full image" ; fi \
    && if [ "$OL" = "false" ] ; then featureManager install  /mytemp/WASPersonaWebServicesHandlerFeature-1.0.0-SNAPSHOT.esa  --when-file-exists=replace --acceptLicense ; fi


# Add interim fixes for WL/OL (optional)
#COPY --chown=1001:0  interim-fixes /opt/ol/fixes/
#COPY --chown=1001:0  interim-fixes /opt/ibm/fixes/


# This script will add the requested XML snippets and grow image to be fit-for-purpose
RUN configure.sh
