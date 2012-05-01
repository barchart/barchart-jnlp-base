/*
 *	build time: ${barchartTimeISO}
 */
/*
 * provides applet html tag configuration parameters
 * http://download.oracle.com/javase/6/docs/technotes/guides/jweb/deployment_advice.html
 */

//##############################

if (typeof appletAttributes == "undefined") {
	appletAttributes = {}; // make global
}

if (typeof appletParameters == "undefined") {
	appletParameters = {}; // make global
}

// ##############################

// defaults
appletAttributes.id="platformApplet";
appletAttributes.mayscript="true";

appletAttributes.codebase = "."; // url to class path jars
appletAttributes.width = "100%"; // default applet size
appletAttributes.height = "100%"; // default applet size


// pivot applet specific
appletParameters.application_class_name = "${pivotClass}";
appletParameters.startup_properties = "${jnlpParameter-startup_properties}";
appletParameters.system_properties = "${jnlpParameter-system_properties}";

// ##############################

// force non-jnlp mode
function usePluginV1() {
	//
	appletAttributes.code = "${mainClassApplet}"; // extends java.awt.Applet
	appletAttributes.archive = "${mainJar}"; // provides INDEX.LIST
	//
}

// force jnlp mode or fail
function usePluginV2() {
	//
	appletAttributes.code = "must-load-from-jnlp"; // extends java.awt.Applet
	appletParameters.jnlp_href = "${jnlpFileApplet}"; // provides jnlp descriptor
	appletParameters.separate_jvm = 'true';
	//
}

// browser plugin should choose maximum available mode
function usePluginV1V2() {
	//
	appletAttributes.code = "${mainClassApplet}"; // extends java.awt.Applet
	appletAttributes.archive = "${mainJar}"; // provides INDEX.LIST
	appletParameters.jnlp_href = "${jnlpFileApplet}"; // provides jnlp descriptor
	appletParameters.separate_jvm = 'true';
	//
}
