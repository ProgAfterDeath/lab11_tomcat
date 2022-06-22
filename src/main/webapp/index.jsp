<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Табуляція</title>
</head>
<body>
<section>
    <jsp:useBean id="arithmetic" scope="session" class="com.example.demo.Arithmetic" />
    <form method="get" action="${pageContext.request.contextPath}/hello-servlet">
        <dl>
            <h2>Введіть необхідні дані</h2>
        </dl>
        <dl>
            <dt>Початкове значення діапазону: <input type="number" name="start" value="${arithmetic.start}" /></dt>
        </dl>
        <dl>
            <dt>Кінцеве значення діапазону: <input type="number" name="end" value="${arithmetic.end}" /></dt>
        </dl>
        <dl>
            <dt>Крок зміни аргумента: <input type="number" name="step" value="${arithmetic.step} " step="0.01" /></dt>
        </dl>
        <dl>
            <dt>Значення аргумента: <input type="number" name="value" value="${arithmetic.value}" step="0.1"/></dt>
        </dl>
        <button type="submit">Розрахувати</button>
    </form>
</section>
</body>
</html>