<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Table Stripes and Row Locking</title>
    <style type="text/css">
        body	{background:#fff;}
        h1		{font:bold 20px/26px Arial;}
        p, li, td	{font:normal 12px/17px Arial;}
        table	{border:0;border-collapse:collapse;}
        td		{padding:4px;}
        th		{font:bold 12px/17px Arial;text-align:left;padding:4px;border-bottom:1px solid #333;}
        tr.odd	{background:#e4dcd9;}
        tr.highlight	{background:#BDA9A2;}
        tr.selected		{background:#4a1200;color:#fff;}
        td+td+td {text-align:right;}
    </style>
    <script type="text/javascript">
        function addLoadEvent(func) {
            var oldonload = window.onload;
            if (typeof window.onload != 'function') {
                window.onload = func;
            } else {
                window.onload = function() {
                    oldonload();
                    func();
                }
            }
        }
        function addClass(element,value) {
            if (!element.className) {
                element.className = value;
            } else {
                newClassName = element.className;
                newClassName+= " ";
                newClassName+= value;
                element.className = newClassName;
            }
        }
        function stripeTables() {
            var tables = document.getElementsByTagName("table");
            for (var m=0; m<tables.length; m++) {
                if (tables[m].className == "pickme") {
                    var tbodies = tables[m].getElementsByTagName("tbody");
                    for (var i=0; i<tbodies.length; i++) {
                        var odd = true;
                        var rows = tbodies[i].getElementsByTagName("tr");
                        for (var j=0; j<rows.length; j++) {
                            if (odd == false) {
                                odd = true;
                            } else {
                                addClass(rows[j],"odd");
                                odd = false;
                            }
                        }
                    }
                }
            }
        }
        function highlightRows() {
            if(!document.getElementsByTagName) return false;
            var tables = document.getElementsByTagName("table");
            for (var m=0; m<tables.length; m++) {
                if (tables[m].className == "pickme") {
                    var tbodies = tables[m].getElementsByTagName("tbody");
                    for (var j=0; j<tbodies.length; j++) {
                        var rows = tbodies[j].getElementsByTagName("tr");
                        for (var i=0; i<rows.length; i++) {
                            rows[i].oldClassName = rows[i].className
                            rows[i].onmouseover = function() {
                                if( this.className.indexOf("selected") == -1)
                                    addClass(this,"highlight");
                            }
                            rows[i].onmouseout = function() {
                                if( this.className.indexOf("selected") == -1)
                                    this.className = this.oldClassName
                            }
                        }
                    }
                }
            }
        }
        function selectRowCheckbox(row) {
            var checkbox = row.getElementsByTagName("input")[0];
            if (checkbox.checked == true) {
                checkbox.checked = false;
            } else
            if (checkbox.checked == false) {
                checkbox.checked = true;
            }
        }
        function lockRow() {
            var tables = document.getElementsByTagName("table");
            for (var m=0; m<tables.length; m++) {
                if (tables[m].className == "pickme") {
                    var tbodies = tables[m].getElementsByTagName("tbody");
                    for (var j=0; j<tbodies.length; j++) {
                        var rows = tbodies[j].getElementsByTagName("tr");
                        for (var i=0; i<rows.length; i++) {
                            rows[i].oldClassName = rows[i].className;
                            rows[i].onclick = function() {
                                if (this.className.indexOf("selected") != -1) {
                                    this.className = this.oldClassName;
                                } else {
                                    addClass(this,"selected");
                                }
                                selectRowCheckbox(this);
                            }
                        }
                    }
                }
            }
        }
        addLoadEvent(stripeTables);
        addLoadEvent(highlightRows);
        addLoadEvent(lockRow);
        function lockRowUsingCheckbox() {
            var tables = document.getElementsByTagName("table");
            for (var m=0; m<tables.length; m++) {
                if (tables[m].className == "pickme") {
                    var tbodies = tables[m].getElementsByTagName("tbody");
                    for (var j=0; j<tbodies.length; j++) {
                        var checkboxes = tbodies[j].getElementsByTagName("input");
                        for (var i=0; i<checkboxes.length; i++) {
                            checkboxes[i].onclick = function(evt) {
                                if (this.parentNode.parentNode.className.indexOf("selected") != -1){
                                    this.parentNode.parentNode.className = this.parentNode.parentNode.oldClassName;
                                } else {
                                    addClass(this.parentNode.parentNode,"selected");
                                }
                                if (window.event && !window.event.cancelBubble) {
                                    window.event.cancelBubble = "true";
                                } else {
                                    evt.stopPropagation();
                                }
                            }
                        }
                    }
                }
            }
        }
        addLoadEvent(lockRowUsingCheckbox);
    </script>
</head>
<body>
<h1>Table 2</h1>
<table
        id="striped2"
        class="pickme"
        caption="Top Grossing Movies">
    <thead>
    <tr>
        <th> </th>
        <th>Category</th>
        <th>Movie</th>
        <th>Gross</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice1"
                    value="walalala" />
        </td>
        <td>Domestic</td>
        <td>Titanic</td>
        <td>$600,788,188</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice2"
                    value="walalala" />
        </td>
        <td>Adjusted for Inflation</td>
        <td>Gone with the Wind</td>
        <td>$1,329,453,600</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice3"
                    value="walalala" />
        </td>
        <td>Worldwide</td>
        <td>Titanic</td>
        <td>$1,845,034,000</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice4"
                    value="walalala" />
        </td>
        <td>R-Rating</td>
        <td>The Passion of the Christ</td>
        <td>$370,274,604</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice5"
                    value="walalala" />
        </td>
        <td>PG-13 Rating</td>
        <td>Titanic</td>
        <td>$600,788,188</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice6"
                    value="walalala" />
        </td>
        <td>PG-Rating</td>
        <td>Star Wars</td>
        <td>$460,998,007</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice7"
                    value="walalala" />
        </td>
        <td>G-Rating</td>
        <td>Finding Nemo</td>
        <td>$339,714,978</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice8"
                    value="walalala" />
        </td>
        <td>NC-17 Rating</td>
        <td>Showgirls</td>
        <td>$20,350,754</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice9"
                    value="walalala" />
        </td>
        <td>Movies that never hit #1</td>
        <td>My Big Fat Greek Wedding</td>
        <td>241,438,208</td>
    </tr>
    <tr>
        <td>
            <input
                    type="checkbox"
                    name="tablechoice10"
                    value="walalala" />
        </td>
        <td>IMAX</td>
        <td>Everest</td>
        <td>$87,178,599</td>
    </tr>
    </tbody></table>
</body>
</html>
