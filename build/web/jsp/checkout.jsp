

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >

<head>
   <title>Order</title>

  
</head>

<%@ page import="model.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<body>
   
<h1 class = "bigFont" align="center"><font face="Georgia, Times New Roman, Times, serif">Shopping 
  Cart Check Out</font></h1>

   <form method = "post" action = "jsp/thankyou.jsp">
    <input type="hidden" name="action" value="validate_credit">
  <p style = "font-weight: bold">&nbsp; </p>
  <table width="100%" border="0" cellspacing="1" cellpadding="1">
    <tr>
      <td bgcolor="#CCCCCC"> 
        <h3 align="left">You have selected to purchase the following Items</h3>
      </td>
    </tr>
    

     <c:set var="s_cart" value="seesionScope.cart"/>
     <c:choose>
         <c:when test="${not empty s_cart}">
             <c:forEach var="item" items="s_cart">
                 <c:set var="cartItem" value="item.value"/> 
              

    <tr>
        <td bgcolor="#F0F0F0"><c:out value="${cartItem}"/></td>
    </tr>
    
    </c:forEach>
    </c:when>
         </c:choose>



  </table>

  <p style = "font-weight: bold">Please input the following information.</p>

      <!-- table of form elements -->
      
  <table>
    <tr> 
      <td class = "right bold">First name:</td>
      <td> 
        <input type = "text" name = "firstname" 
                  size = "25" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">Last name:</td>
      <td> 
        <input type = "text" name = "lastname" 
                  size = "25" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">Street:</td>
      <td> 
        <input type = "text" name = "street" size = "25" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">City:</td>
      <td> 
        <input type = "text" name = "city" size = "25" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">State:</td>
      <td> 
        <input type = "text" name = "state" size = "2" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">Zip code:</td>
      <td> 
        <input type = "text" name = "zipcode" 
                  size = "10" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">Phone #:</td>
      <td> ( 
        <input type = "text" name = "phone" size = "3" />
        ) 
        <input type = "text" name = "phone2" 
                      size = "3" />
        - 
        <input type = "text" name = "phone3" size = "4" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">Credit Card #:</td>
      <td> 
        <input type = "text" name = "card_num" 
                  size = "25" />
      </td>
    </tr>
    <tr> 
      <td class = "right bold">Expiration (mm/yy):</td>
      <td> 
        <input type = "text" name = "expires" 
                  size = "2" />
        / 
        <input type = "text" name = "expires2" 
                  size = "2" />
      </td>
    </tr>
    <tr>
      <td class = "right bold">Order Amount $</td>
      <td>
        <input type="text" name="amount" value="${totalCostOfOrder}" />
      </td>
    </tr>
  </table>

      <!-- enable user to submit the form  -->
      <p><input type = "submit" value = "Submit" /></p>
   </form>
</body>

</html>
