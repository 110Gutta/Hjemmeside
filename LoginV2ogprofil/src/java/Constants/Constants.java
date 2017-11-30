/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

/**
 *
 * @author nilsf
 */
public interface Constants
{
    ////////////////////////////////////////////////////////////////
    // servlet urls
    //
    String LOGIN = "login";
    String FRONT = "frontpage";
    String FRONT_P = "/frontpage";
    String STUDENTPAGE = "studenprofile";
    String STUDENTPAGE_P = "/studentprofile";
    
    
    ////////////////////////////////////////////////////////////////
    // html page fragments
    //
    String SLIT_VERSION = "v0.0.3";

    String DOC_BEGIN = "<!DOCTYPE html>\n<html lang='en'>\n";
    String DOC_END = "</html>";

    String HEAD = "  <head>\n    <meta charset=\"UTF-8\">\n    <title>%s</title>\n"
            + "    <link rel=\"stylesheet\" href=\"slit.css\"/>\n  </head>\n";
    String BODY_BEGIN = "  <body>\n";
    String BODY_END = "  </body>\n";

    String HEADER_BEGIN = "    <header>\n"
            + "      <h1>SLIT %s</h1>\n";
    String HEADER_END = "    </header>\n";

    String MENU_BEGIN = "    <nav>\n      <ul>\n";
    String MENU_END = "      </ul>\n    </nav>\n";

    String MESSAGES_BEGIN = "    <footer>\n";
    String MESSAGES_END = "    </footer>\n";

    String FORM_BEGIN = "<form action='%s' method='POST'>\n";
    String FORM_END = "</form>\n";

    String TABLE_BEGIN = "<table>\n";
    String TABLE_END = "</table>\n";
    
    ////////////////////////////////////////////////////////////////
    // form fields with prompts, laid out in two-column table
    //
    String INPUT_FIELD
            = "<tr><td>%s</td>"
            + "<td><input type='text' name='%s' value='%s'/></td></tr>\n";
    String EMPTY_FIELD
            = "<tr><td>%s</td><td><input type='text' name='%s'/></td>";
    
    
     ////////////////////////////////////////////////////////////////
    // Parameter names
    //
    String USERNAME = "username";
    String ID_PARAM = "id";
    String NAME_PARAM = "name";
    String GOALS_PARAM = "learninggoals";
    
     ////////////////////////////////////////////////////////////////
    // request attribute names
    //
    String MSG_ATTR = "messages";
    String MODULE_ATTR = "module";
    String MODULE_LIST_ATTR = "modulelist";
    String STUDENT_ATTR = "student";
    String STUDENT_LIST_ATTR = "studentlist";
    String CURRENT_MODULE_STATUS = "currentmodule";
    String WAITING_STUDENTS = "waitingstudents";




}
