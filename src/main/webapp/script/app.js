/**
 * 
 */
var idleTime = 0.0;
$(document).ready(function () {
    //Increment the idle time counter every minute.
    var idleInterval = setInterval(timerIncrement, 5000); // 5 seconds

    //Zero the idle timer on mouse movement.
    $(this).mousemove(function (e) {
        idleTime = 0;
    });
    $(this).keypress(function (e) {
        idleTime = 0;
    });
});

function timerIncrement() {
    idleTime = idleTime + 1;
    console.log("Inactivity time: " + idleTime);
    if (idleTime === 48) { // show pop up
    	//console.log("show pop up");
    	$("#logout_div").load(getContextPath() + "/static/logoutPopup.jsp");
    }
    if (idleTime > 48) { // update progress bar
    	var progressVal = $("#logoutProgress").val() + 5;
    	//console.log("update progress: " + progressVal);
    	$("#logoutProgress").val(progressVal);
    }
    if (idleTime > 60) { // logout
    	//console.log("logging out");
    	document.location.href = getContextPath() + "/logout";
    	idleTime = 0;
    }
} 

function callUserController() {
	document.location.href = getContextPath() + "/user/method/";
}

function callAdminController() {
	document.location.href = getContextPath() + "/admin/method/";
}

function callUserService() {
	document.location.href = getContextPath() + "/user/service/method/";
}

function callAdminService() {
	document.location.href = getContextPath() + "/admin/service/method/";
}

function extendSession() {
	//console.log("session extended");
	window.location.reload();
	idleTime = 0;
}

function logOut() {
	//console.log("session logout");
	document.location.href = getContextPath() + "/logout";
	idleTime = 0;
}

function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}