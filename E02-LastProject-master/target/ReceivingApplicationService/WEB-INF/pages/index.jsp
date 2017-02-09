<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.02.2017
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style1.css"/>" type="text/css" rel="stylesheet">
    <script src="<c:url value="/resources/js/common1.js" />"></script>
    <script src="<c:url value="/resources/js/common2.js" />"></script>
    <title>collage</title>

    <script type="text/javascript">

        $( init );

        function init() {
            $('.makeMeDraggable').draggable( {
                cursor: 'move',
                containment: 'document',
                helper: clone.attr('id', 'newId')
                //helper: 'clone'
                // helper: myHelper
            } );
            $('.makeMeDroppable').droppable( {
                drop: handleDropEvent
            } );

        }

        function myHelper( event ) {
            return '<div class="draggableHelper"> <img class="img" src="../../../../../../popytka2/попытка2/images/1.jpg" alt=""> </div>';
        }

        function handleDropEvent( event, ui ) {
            var draggable = ui.draggable;
            alert( 'Квадрат с ID "' + draggable.attr('class') + '" был доставлен к месту назначения!' );
        }


    </script>

</head>
<body style="background-color: #DCDCDC;">

<div id="content" style="height: 200px;">
    <div class="wrapper">
        <c:forEach var="num" items="${images}">
            <c:forEach var="num" items="${images}">
                <div class="ui-draggable makeMeDraggable" style="position: relative;">
                ${num}<br/>
                </div>
        </c:forEach>
        <div class="ui-draggable makeMeDraggable" style="position: relative;">
            <img class="img" src="../../../../../../popytka2/попытка2/images/1.jpg" alt="">
        </div>
        <div class="ui-draggable makeMeDraggable" style="position: relative;" >
            <img class="img" src="../../../../../../popytka2/попытка2/images/2.jpg" alt="">
        </div>
        <div class="ui-draggable makeMeDraggable" style="position: relative;" >
            <img class="img" src="../../../../../../popytka2/попытка2/images/3.jpg" alt="">
        </div>
        <div class="ui-draggable makeMeDraggable" style="position: relative;" >
            <img class="img" src="../../../../../../popytka2/попытка2/images/4.jpg" alt="">
        </div>
        <div class="ui-draggable makeMeDraggable" style="position: relative;" >
            <img class="img" src="../../../../../../popytka2/попытка2/images/5.jpg" alt="">
        </div>
    </div>

    <div class="ui-droppable makeMeDroppable" >
    </div>

</div>
</div>

</body>
</html>
