/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.46
 * Generated at: 2018-01-10 10:43:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.html_005fcss;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>TweetBook</title>\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"main.js\"></script>\n");
      out.write("\t<link href=\"style.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div class=\"cont_principal\">\n");
      out.write("  \t\t<div class=\"cont_centrar\">\n");
      out.write("  \t\t\t<div class=\"cont_login\">\n");
      out.write("  \t\t\t\t<form action=\"\">\n");
      out.write("    \t\t\t\t<div class=\"cont_tabs_login\">\n");
      out.write("      \t\t\t\t\t<ul class='ul_tabs'>\n");
      out.write("        \t\t\t\t\t<li class=\"active\">\n");
      out.write("        \t\t\t\t\t\t<a href=\"#\" onclick=\"sign_in()\">SIGN IN</a>\n");
      out.write("        \t\t\t\t\t\t<span class=\"linea_bajo_nom\"></span>\n");
      out.write("       \t\t\t\t\t\t</li>\n");
      out.write("        \t\t\t\t\t<li>\n");
      out.write("        \t\t\t\t\t\t<a href=\"#up\" onclick=\"sign_up()\">SIGN UP</a>\n");
      out.write("        \t\t\t\t\t\t<span class=\"linea_bajo_nom\"></span>\n");
      out.write("        \t\t\t\t\t</li>\n");
      out.write("      \t\t\t\t\t</ul>\n");
      out.write("      \t\t\t\t</div>\n");
      out.write(" \t\t\t\t\t<div class=\"cont_text_inputs\">\n");
      out.write(" \t\t\t\t\t\t\n");
      out.write("      \t\t\t\t\t<input type=\"text\" class=\"input_form_sign \" placeholder=\"LOGIN\" name=\"login\" />\n");
      out.write("    \t\t\t\t\t<input type=\"text\" class=\"input_form_sign d_block active_inp\" placeholder=\"EMAIL\" name=\"email\" />\n");
      out.write("    \t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"input_form_sign d_block  active_inp\" placeholder=\"PASSWORD\" name=\"pass_us\" />\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"input_form_sign\" placeholder=\"CONFIRM PASSWORD\" name=\"conf_pass_us\" />\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"input_form_sign \" placeholder=\"FIRSTNAME\" name=\"firstname\" />\n");
      out.write(" \t\t\t\t\t\t<input type=\"text\" class=\"input_form_sign \" placeholder=\"NAME\" name=\"name\" />\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("    \t\t\t\t\t<a href=\"#\" class=\"link_forgot_pass d_block\" >Forgot Password ?</a>    \n");
      out.write("\t\t\t\t\t\t<div class=\"terms_and_cons d_none\">\n");
      out.write("    \t\t\t\t\t\t<p><input type=\"checkbox\" name=\"terms_and_cons\"/> <label for=\"terms_and_cons\">I'm not Robot</label></p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"cont_btn\">\n");
      out.write("\t\t\t\t\t\t<button class=\"btn_sign\">SIGN IN</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("    \t\t\t</form>\n");
      out.write("    \t\t</div>\n");
      out.write("    \t</div>\n");
      out.write("    </div>\n");
      out.write("\t\n");
      out.write("\t<script language=\"JavaScript\">\n");
      out.write("\t\t\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
