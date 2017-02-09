<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>

    <style type="text/css">
        .search {
            font-family: arial;
            padding: 50px;
        }

        table {
            border-collapse: collapse;
            border: 1px solid grey;
            width: 500px;
            margin: auto;
            margin-top: 10px;
            font-family: arial;
        }

        td {border: 1px solid grey;}

        table {border: 3px solid grey;}

        .button {
            font-weight: 700;
            border-radius: 3px;
        }

        .button:hover {
            background: rgb(53, 167, 110);
            cursor: pointer;
        }

        #searchButton {
            background: #00FF00;
        }

        #resetButton {
            background: #FF0000;
        }

        #searchText {
            width: 30%;
        }

    </style>

    <script>
        $(document).ready(function () {
            $('#searchButton').click(function(){
                var $ImageTable=$('<table class="table" align="center"></table>');

                var images={"resources":[{"bytes":76460,"format":"jpg","resource_type":"image","width":600,"secure_url":"https://res.cloudinary.com/depejwdfb/image/upload/v1486385587/vmunewl1rnqv63j5sjie.jpg","created_at":"2017-02-06T12:53:07Z","type":"upload","version":1486385587,"url":"http://res.cloudinary.com/depejwdfb/image/upload/v1486385587/vmunewl1rnqv63j5sjie.jpg","public_id":"vmunewl1rnqv63j5sjie","height":600},{"bytes":210054,"format":"jpg","resource_type":"image","width":2400,"secure_url":"https://res.cloudinary.com/depejwdfb/image/upload/v1486384665/oylg9qupnc9od8m2nr21.jpg","created_at":"2017-02-06T12:37:45Z","type":"upload","version":1486384665,"url":"http://res.cloudinary.com/depejwdfb/image/upload/v1486384665/oylg9qupnc9od8m2nr21.jpg","public_id":"oylg9qupnc9od8m2nr21","height":1600},{"bytes":56996,"format":"jpg","resource_type":"image","width":593,"secure_url":"https://res.cloudinary.com/depejwdfb/image/upload/v1486383384/ipkssxijg4l8qks0pztc.jpg","created_at":"2017-02-06T12:16:24Z","type":"upload","version":1486383384,"url":"http://res.cloudinary.com/depejwdfb/image/upload/v1486383384/ipkssxijg4l8qks0pztc.jpg","public_id":"ipkssxijg4l8qks0pztc","height":305}]}

                $.each(images.resources, function (keyFilm, valFilm) {
                    $.each(valFilm, function(keyAttr, valAttr)
                    {
                        if (keyAttr==='url') {
                            var $filtAttrTr=$("<img src=&quot;"+valAttr+"&quot; alt=&quot;alternative text&quot; />");

                            // var $filtAttrTr=$('<tr><td>' + keyAttr + '</td><td>' + valAttr  + '</td></tr>');
                            $ImageTable.append($filtAttrTr);
                        }
                    });
                    $('#results').append($ImageTable);
                });
            });

            $('#resetButton').click(function(){
                $('#searchText').val('');
                $('#results').html('');
            });
        });

        function ajaxReuest(term){
            $.ajax({
                type: 'GET',
                url: 'http://api.kinopoisk.cf/searchFilms',
                data: {'keyword': term},
                success: function(data){
                    if(data.searchFilms.length > 0)
                    {
                        $.each(data.searchFilms, function (keyFilm, valFilm) {

                            var $filmTable=$('<table class="table" align="center"></table>');
                            $.each(valFilm, function(keyAttr, valAttr)
                            {
                                var $filtAttrTr=$('<tr><td>' + keyAttr + '</td><td>' + valAttr  + '</td></tr>');
                                $filmTable.append($filtAttrTr);
                            });
                            $('#results').append($filmTable);
                        });
                    }
                    else
                    {
                        alert("Нет такого фильма:(")
                    }
                }
            });
        }
    </script>

</head>
<body>
<div class="search" align="center">
    <input id="searchText" type="text" placeholder="Введите название фильма"/>
    <input id="searchButton" class="button" type="button" value="Искать"/>
    <input id="resetButton" class="button" type="button" value="Сбросить">
</div>

<div id="results"></div>
</body>
</html>
