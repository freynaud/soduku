package com.ebay.web.view;

import com.ebay.web.model.Position;
import com.ebay.web.model.SodokuModel;

public class SodukuGridView implements View {

  private final SodokuModel model;

  public SodukuGridView(SodokuModel model) {
    this.model = model;
  }

  @Override
  public String render() {

    StringBuilder b = new StringBuilder();

    b.append("<html>");
    b.append(" <script src='//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>");

    b.append("<script>"
             + "$(document).ready(function(){\n"
             + "  $('.todo').keyup(function(){\n"
             + "var i = $(this).attr('line');\n"
             + "var j = $(this).attr('col');\n"
             + "var v = $(this).val();\n"
             + "console.log(i+','+j+'='+v);\n"
             + "var data = {};\n"
             + "data.line=i;\n"
             + "data.col=j;\n"
             + "data.v=v;\n"

             + "$.ajax({"
             + "type:'POST',"
             + "url:'json.html',"
             + "data:data,"
             + "success: function(data, textStatus, jqXHR) {\n"
             + "  console.log(data);\n"
             + "},"
             + "dataType:'json'});"
             + "});"
             + "});"
             + "</script>");

    b.append("<head>");

    b.append("</head>");
    b.append("<table border='1'>");
    for (int i = 0; i < 9; i++) {
      if (i == 0) {
        b.append("<tr  >");
      }
      for (int j = 0; j < 9; j++) {
        int value = model.get(new Position(i, j));
        b.append("<td width='22px'>");
        if (value == -1) {
          b.append("<input type='text' class='todo' line='" + i + "' col='" + j + "'></input>");
        } else {
          b.append(value);
        }
        b.append("</td>");
        if (j == 8) {
          b.append("</tr>");
        } else {
          b.append(" , ");
        }
      }
    }
    b.append("</table>");
    b.append("</html>");
    return b.toString();
  }
}
