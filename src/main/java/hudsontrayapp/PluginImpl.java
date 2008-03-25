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

	public void doLaunch(StaplerRequest req, StaplerResponse res) throws IOException{
		res.setHeader("Content-Disposition", "filename=launch.jnlp");
		res.setContentType("application/x-java-jnlp-file");
		Writer w = res.getWriter();
		w.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		w.write("<jnlp codebase=\""); w.write(req.getRootPath() + "/plugin/hudsontrayapp/"); w.write("\">");
		w.write("<information>");
        w.write("<title>Hudson Tray Application</title>");
        w.write("<vendor>David Hayes</vendor>");
        w.write("</information>");
        w.write("<security><all-permissions/></security>");
        w.write("<resources>");
        w.write("<j2se version=\"1.6+\" initial-heap-size=\"32m\" max-heap-size=\"32m\"/>");
        w.write("<jar href=\"HudsonTrayApp.jar\" main=\"true\" download=\"eager\"/>");
        w.write("</resources>");
        w.write("<application-desc main-class=\"org.hudson.trayapp.HudsonTrayApp\">");
        w.write("<argument>server="); w.write(req.getRootPath()); w.write("/</argument>"); 
        w.write("</application-desc>");
        w.write("</jnlp>");
        w.close();
	}
}
