/**
 * Created by hongjian on 2015/11/22.
 */

function getMessageGet(){
    var name = document.getElementById("name").value;
    var account = document.getElementById("account").value;
    var xhr = createXMLHttpRequest();
    xhr.onreadystatechange = doOnReadystatechange1;
    xhr.open("GET","/ajaxServlet.servlet?name="+name+"&account="+account+"&content_Type=x-www-form-urlencoded",true);
    xhr.send(null);
}

function getMessagePost(){
    var name = document.getElementById("name").value;
    var account = document.getElementById("account").value;
    var xhr = createXMLHttpRequest();
    xhr.onreadystatechange = doOnReadystatechange1;
    xhr.open("POST","/ajaxServlet.servlet",true);
    //POST方式,必须设置Content-type,后台request里面接收不到值
    //表单默认的enctype 是 application/x-www-form-urlencoded
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send("name="+name+"&account="+account+"&content_Type=x-www-form-urlencoded");
}


function getMessageXML(){
    var name = document.getElementById("name").value;
    var account = document.getElementById("account").value;
    var xhr = createXMLHttpRequest();
    xhr.onreadystatechange = doOnReadystatechangeXML;
    xhr.open("POST","/ajaxServlet.servlet",true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send("name="+name+"&account="+account+"&content_Type=xml");

}

function getMessageJSON(){
    var name = document.getElementById("name").value;
    var account = document.getElementById("account").value;
    var xhr = createXMLHttpRequest();
    xhr.onreadystatechange = doOnReadystatechangeJSON;
    xhr.open("POST","/ajaxServlet.servlet",true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send("name="+name+"&account="+account+"&content_Type=json");
}

function getMessageHTML(){
    var name = document.getElementById("name").value;
    var account = document.getElementById("account").value;
    var xhr = createXMLHttpRequest();
    xhr.onreadystatechange = doOnReadystatechangeHTML;
    xhr.open("POST","/ajaxServlet.servlet",true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send("name="+name+"&account="+account+"&content_Type=html");

}

function createXMLHttpRequest(){
    if(window.ActiveXObject){
        return new ActiveXObject("Microsoft.XMLHTTP");
    } else if(window.XMLHttpRequest){
        return new XMLHttpRequest();
    }
}

function doOnReadystatechange1(){
   if(this.readyState == 4 && this.status == 200){
      document.getElementById("message1").innerHTML = this.responseText;
   }
}

function doOnReadystatechangeXML(){
    if(this.readyState == 4 && this.status == 200){
        var content = this.responseXML;
        document.getElementById("message2").innerHTML =  content.getElementById("result").innerHTML;
    }
}

function doOnReadystatechangeJSON(){

    if(this.readyState == 4 && this.status == 200){
        var obj = eval("(" + this.responseText + ")");
        document.getElementById("message3").innerHTML = obj.msg;
    }


}

function doOnReadystatechangeHTML(){

    if(this.readyState == 4 && this.status == 200){
        document.getElementById("message4").innerHTML = this.responseText;
    }
}



function onInitProvince(){
    var xhr = createXMLHttpRequest();
    xhr.onreadystatechange = initProvince;
    xhr.open("POST","/ajaxServlet.servlet",true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send("method=provices");
}

function initProvince() {
    if (this.readyState == 4 && this.status == 200) {
        var selectP = document.getElementById("Provinces");
        var fragment = document.createDocumentFragment();
        var optionNull = document.createElement("option");
        optionNull.innerHTML = "--";
        optionNull.id = "-1";
        fragment.appendChild(optionNull);
        var o = eval("(" + this.responseText + ")");
        var objs = o.provinces;
        for(var i = 0 ; i < objs.length ; i ++){
            var obj = objs[i];
            var option = document.createElement("option");
            option.innerHTML = obj.province;
            option.id = obj.id;
            fragment.appendChild(option);
        }
        selectP.appendChild(fragment);
    }
}

function getCities(select){


    var options = select.selectedOptions;
    var option = options[0];
    var xhr = createXMLHttpRequest();
    xhr.onreadystatechange = getCities1;
    xhr.open("POST","/ajaxServlet.servlet",true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send("method=cities&id="+option.id);
}

function getCities1(){
    if (this.readyState == 4 && this.status == 200) {
        var selectC = document.getElementById("Cities");
        selectC.innerHTML = "";
        var fragment = document.createDocumentFragment();
        var optionNull = document.createElement("option");
        optionNull.innerHTML = "--";
        optionNull.id = "-1";
        fragment.appendChild(optionNull);
        var o = eval("(" + this.responseText + ")");
        var objs = o.cities;
        for (var i = 0; i < objs.length; i++) {
            var obj = objs[i];
            var option = document.createElement("option");
            option.innerHTML = obj.city;
            option.id = obj.id;
            fragment.appendChild(option);
        }
        selectC.appendChild(fragment);
    }
}
