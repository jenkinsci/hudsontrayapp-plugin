package hudsontrayapp;

import java.io.IOException;
import java.io.Writer;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.Plugin;
import hudson.model.Hudson;

/**
 * Entry point of a plugin.
 *
 * <p>
 * There must be one {@link Plugin} class in each plugin.
 * See javadoc of {@link Plugin} for more about what can be done on this class.
 *
 * @author Kohsuke Kawaguchi
 * @plugin hudsontrayapp
 */
public class PluginImpl extends Plugin {
    public void start() throws Exception {
    	Hudson.getInstance().getActions().add(new TrayAppAction());
    }

	public void doLaunch(StaplerRequest req, StaplerResponse res) throws IOException {
		res.setHeader("Content-Disposition", "filename=launch.jnlp");
		res.setContentType("application/x-java-jnlp-file");
		Writer w = res.getWriter();
		w.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		w.write("<jnlp codebase=\""); w.write(req.getRootPath() + "/plugin/hudsontrayapp/"); w.write("\">");
		w.write("<information>");
        w.write("<title>Hudson Tray Application</title>");
        w.write("<vendor>David Hayes</vendor>");
        w.write("<offline-allowed/>");
		w.write("</information>");
        w.write("<security><all-permissions/></security>");
        w.write("<resources>");
        w.write("<jar href=\"HudsonTrayApp.jar\" main=\"true\" download=\"eager\"/>");
        w.write("<j2se version=\"1.6+\" initial-heap-size=\"32m\" max-heap-size=\"32m\"/>");
        w.write("<j2se version=\"1.5\" initial-heap-size=\"32m\" max-heap-size=\"32m\">");
        w.write("<resources>");
        w.write("<extension name=\"jdic\" href=\"jdic\"/>");
        w.write("</resources>");
        w.write("</j2se>");
        w.write("<j2se version=\"1.4\" initial-heap-size=\"32m\" max-heap-size=\"32m\">");
        w.write("<resources>");
        w.write("<extension name=\"jdic\" href=\"jdic\"/>");
        w.write("</resources>");
        w.write("</j2se>");
        w.write("</resources>");
        w.write("<application-desc main-class=\"org.hudson.trayapp.HudsonTrayApp\">");
        w.write("<argument>server="); w.write(req.getRootPath()); w.write("/</argument>"); 
        w.write("</application-desc>");
        w.write("</jnlp>");
        w.close();
	}
	
	public void doJdic(StaplerRequest req, StaplerResponse res) throws IOException {
		res.setHeader("Content-Disposition", "filename=jdic.jnlp");
		res.setContentType("application/x-java-jnlp-file");
		Writer w = res.getWriter();
		w.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		w.write("<jnlp codebase=\""); w.write(req.getRootPath() + "/plugin/hudsontrayapp/"); w.write("\">");
		w.write("<information>");
		w.write("<title>JDesktop Integration Components</title>");
		w.write("<vendor>Hudson Tray Application</vendor>");
		w.write("<offline-allowed/>");
		w.write("</information>");
		w.write("<security>");
		w.write("<all-permissions/>");
		w.write("</security>");
		w.write("<resources>");
		w.write("<jar href=\"jdic.jar\"/>");
		w.write("</resoures>");
		w.write("<resources os=\"Windows\">");
		w.write("<jar href=\"win/jdic_stub.jar\"/>");
		w.write("<nativelib href=\"win/x86/jdic-native.jar\"/>");
		w.write("</resources>");
		w.write("<resources os=\"Linux\">");
		w.write("<jar href=\"lin/jdic_stub.jar\"/>");
		w.write("<nativelib href=\"lin/x86/jdic-native.jar\"/>");
		w.write("</resources>");
		w.write("<resources os=\"SunOS\" arch=\"sparc\">");
		w.write("<jar href=\"sun/jdic_stub.jar\"/>");
		w.write("<nativelib href=\"sun/sparc/jdic-native.jar\"/>");
		w.write("</resources>");
		w.write("<resources os=\"SunOS\" arch=\"x86\">");
		w.write("<jar href=\"sun/jdic_stub.jar\"/>");
		w.write("<nativelib href=\"sun/x86/jdic-native.jar\"/>");
		w.write("</resources>");
		w.write("<component-desc/>");
		w.write("</jnlp>");
		w.close();
	}
}
