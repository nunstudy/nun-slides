/**
* Author: Aaron S. Timbo
* Date Created: 2012-05018
* 
* Custom jQuery for nun-slides application.
*/
var debug = true;
var raphaeljs = false;

$(document).ready(function() {
	$('#infoMessage').hide();
	
	if (debug) {
		$('#infoMessage').show();
		$('#infoMessage').html("jQuery Loaded!");
	}
	
	if (raphaeljs) {
		drawCircle();		
	}
	
	$("#id").focus();
		
});

function drawCircle() {
	// Creates canvas 320 × 200 at 10, 50
	var paper = Raphael(10, 50, 320, 200);
	// Creates circle at x = 50, y = 40, with radius 10
	var x = 70;
	var y = 50;
	var r = 20;
	var circle = paper.circle(x, y, r);
	
	circle.attr("fill", "#f00");
	
	circle.attr("stroke", "#000");
	
	var ms = 500;	// milliseconds
	circle.mouseover(function() {
		circle.stop().animate({transform: "s2 2 " + x + " " + y}, ms, "elastic");
	}).mouseout(function() {
		circle.stop().animate({transform: ""}, 100, "elastic");
	});
	
	$('#canvas').html(paper);
}