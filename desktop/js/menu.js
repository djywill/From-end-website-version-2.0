    var nav = document.getElementById("menu_1").childNodes;
    for (var i = 0; i < nav.length; i++) {
        if (nav[i].className == "menuli") {
            nav[i].onmousemove= function () { fnNav(this, "block") };
            nav[i].onmouseout = function () { fnNav(this, "none") };
        }
    }
    function fnNav(obj, flag) {
        obj.getElementsByTagName("dl")[0].style.display = flag;
    }