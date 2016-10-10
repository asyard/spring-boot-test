<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h3>Search a book</h3>
<form method="POST" action="/book" id="form1">
    <table>
        <tr>
            <td><label path="bookId">Id : </label></td>
            <td><input type="bookId" name="bookId"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>

<form method="GET" action="/bookbyname" id="form2">
    <table>
        <tr>
            <td><label path="bookName">Name : </label></td>
            <td><input type="bookName" name="bookName"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>



</body>
</html>