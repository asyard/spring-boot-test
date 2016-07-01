<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h3>Add a book</h3>
<form method="POST" action="/addbook">
    <table>
        <tr>
            <td><label path="id">Id</label></td>
            <td><input type="input" name="id"/></td>
        </tr>
        <tr>
            <td><label path="name">Name</label></td>
            <td><input type="input" name="name"/></td>
        </tr>
        <tr>
            <td><label path="author">Author</label></td>
            <td><input type="input" name="author"/></td>
        </tr>
        <tr>
            <td><label path="year">Year</label></td>
            <td><input type="input" name="year"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>