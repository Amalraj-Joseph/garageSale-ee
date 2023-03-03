/**
 * 
 */
package pagecode.resources.components;

import jakarta.faces.component.html.HtmlForm;
import jakarta.faces.component.html.HtmlOutputText;
import jakarta.inject.Named;
import pagecode.PageCodeBase;

/**
 * @author JAGRAJ
 *
 */
@Named("pc_OnSaleContent")
public class OnSaleContent extends PageCodeBase {

	protected HtmlOutputText text2;
	protected HtmlForm playProductDemoVideoForm;
	protected HtmlOutputText fileName;
	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlForm getPlayProductDemoVideoForm() {
		if (playProductDemoVideoForm == null) {
			playProductDemoVideoForm = (HtmlForm) findComponentInRoot("playProductDemoVideoForm");
		}
		return playProductDemoVideoForm;
	}

	protected HtmlOutputText getFileName() {
		if (fileName == null) {
			fileName = (HtmlOutputText) findComponentInRoot("fileName");
		}
		return fileName;
	}

}
