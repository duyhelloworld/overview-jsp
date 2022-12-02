<!DOCTYPE html>
<head>
    <title>Hello JSP</title>
</head>
<body>
    <style>
        .container{
            margin-top: 10%;
            display: block;
            text-align: center;
            border: 2px solid #888;
            border-radius: 25px;
            box-shadow: 1px 1px #bbb;
        }
        input[type="submit"]{
            background-color: #888;
            color: #089;
            padding: 10px;
            border-radius: 15px;
        }
        input[type="email"]{
            padding: 10px;
            border-radius: 2px;
            border: 1px solid #ccc;
        }
        input[type="submit"]:active{
            background-color: rgba(80, 80, 90, 0.6);
            color: white;
        }
        input[type="password"]{
            margin-top: 5px;
            background-color: black;
            color: #888;
            padding: 10px;
            border-radius: 2px;
            border: 1px solid #ccc;
        }


    </style>
   <div class="container">
     <h2>Hello World!</h2>
     <br>
    <h3>Enter your mail and pass to login</h3> <br>
    <input type="email" name="email" id="email"> <br>
    <input type="password"> <br>
    <input type="submit" id="submit" value="Submit!">
   </div>
</body>
</html>