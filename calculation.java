/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vrush
 */
public class calculation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            /* TODO output your page here. You may use following sample code. */
            
            int p = Integer.parseInt(request.getParameter("p"));
            double r = Double.parseDouble(request.getParameter("r"));
            int y = Integer.parseInt(request.getParameter("y"));
            int m = Integer.parseInt(request.getParameter("m"));
            String r1 = request.getParameter("r1");
            String opr = request.getParameter("opr");
            
            int year = (y*12)+m;
            double t,n = 1;
            t = year/12;
            double rate = r/100;
            double si,ci;
            if(r1.equals("si"))
            {
                si = (p*r*year)/100;
                out.println("<html>");
                out.println("<body>");
                out.println("<table align=center width=40% style=border-radius:20px;margin-top:100px>");
                out.println("<tr style=background:MistyRose><td><h1 align=center style=color:Indigo;font-size:40px;margin-top:50px>Simple Interest Calculation</h1><br/><br/>");
                out.println("<div style=margin-left:40px;margin-top:-20px><p style=font-size:23px;color:DarkRed>Principle : "+p+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>Rate : "+r+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>Total Months : "+year+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>Simple Interest : "+Math.floor(si)+"</p></div>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
            else if(r1.equals("ci"))
            {
                if(opr.equals("daily1"))
                {
                      n=n*365;
                }
                else  if(opr.equals("daily2"))
                {
                    n=n*360;
                }
                 else  if(opr.equals("week"))
                 {
                     n=n*52;
                 }
                 else  if(opr.equals("biweek"))
                 {
                     n=n*26;
                 }
                 else  if(opr.equals("halfmonth"))
                 {
                     n=n*24;
                 }
                 else  if(opr.equals("month"))
                 {
                     n=n*12;
                 }
                 else  if(opr.equals("bimonth"))
                 {
                     n=n*6;
                 }
                 else  if(opr.equals("quarter"))
                 {
                     n=n*4;
                 }
                 else  if(opr.equals("halfyear"))
                 {
                     n=n*2;
                 }
                 else  if(opr.equals("year"))
                 {
                     n=n*1;
                 }
                double A=p*Math.pow(1+(rate/n),n*t);
                out.println("<html>");
                out.println("<body>");
                out.println("<table align=center width=45% style=margin-top:100px>");
                out.println("<tr style=background:MistyRose><td><h1 align=center style=color:Indigo;font-size:40px;margin-top:50px>Compound Interest Calculation</h1><br/><br/>");
                out.println("<div style=margin-left:35px;margin-top:-20px><p style=font-size:23px;color:DarkRed>Principle : "+p+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>Rate : "+r+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>year : "+y+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>Month : "+m+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>Compound Interest : "+Math.floor(A)+"</p>");
                out.println("<p style=font-size:23px;color:DarkRed>Total Interest Payable : "+Math.floor(A-p)+"</p></td></tr>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
           
            else
            {
                out.println("no any selected");
            }
                      
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
