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
	
	//$("#id").focus();
	// Clear text of search box when user clicks in it
	$("#id").focus(function() {
		if (this.value == this.title) {
			$(this).val('');			
		}
	});
		
	// Close all blocks by default
	$("div[id*='blockHeader']").addClass("closed");
	$("div[id*='blockHeader']").next().hide();
	
	$("div[id*='blockHeader']").click(function() {
		$(this).next().toggle('fast');
		if ($(this).hasClass("open")) {
			$(this).removeClass("open");
			$(this).addClass("closed");			
		} else {
			$(this).removeClass("closed");
			$(this).addClass("open");						
		}
		return false;
	}).next().hide();
	
	// Show all block divs
	$(".showAll").click(function() {
		$("div[id*='blockHeader']").each(function() {
			$(this).removeClass("closed");
			$(this).addClass("open");										
			$(this).next().show('fast');
		});
	});

	// Hide all block divs
	$(".hideAll").click(function() {
		$("div[id*='blockHeader']").each(function() {
			$(this).removeClass("open");
			$(this).addClass("closed");										
			$(this).next().hide('fast');
		});
	});

	// Show a specific block div on load
	var blockHeaderToOpen = '#blockHeader' + $("#blockToOpen").val();
	$(blockHeaderToOpen).removeClass("closed");
	$(blockHeaderToOpen).addClass("open");										
	$(blockHeaderToOpen).next().show();
	
	// Setup block edit form dialog 
	$("#blockEditFormDialog").dialog({
		autoOpen: false,
		height: 350,
		width: 380,
		modal: true		
	});
	
	// Open block edit form dialog 
	$("a[id*='blockEditFormOpenLink_']").click(function() {
		 $('body').css('overflow','hidden');
		$("#blockEditFormDialog").dialog("open");
		if (debug) {
			$('#infoMessage').html("Dialog opened");
		}
	});
	
	// Close block edit form dialog 
    $("#blockEditFormCancelBtn").click(function() {
    	$('body').css('overflow','scroll');
		$("#blockEditFormDialog").dialog("close");  
		return false;
    });
 
	// Setup stain edit form dialog 
	$("#stainEditFormDialog").dialog({
		autoOpen: false,
		height: 150,
		width: 350,
		modal: true		
	});
	
	// Open block edit form dialog 
	$("a[id*='stainEditFormOpenLink_']").click(function() {
		 $('body').css('overflow','hidden');
		$("#stainEditFormDialog").dialog("open");
		if (debug) {
			$('#infoMessage').html("Dialog opened");
		}
	});
	
	// Close block edit form dialog 
    $("#stainEditFormCancelBtn").click(function() {
    	$('body').css('overflow','scroll');
		$("#stainEditFormDialog").dialog("close");  
		return false;
    });
    
    $('.ui-button').hover(function() {
    	$(this).addClass('ui-state-hover');
    },
    function(){
    	$(this).removeClass('ui-state-hover');    	    
    });
    
    // Zebra stripe block row divs
    $(".blockRow:odd").addClass('odd');
    
    // Execute link click when table row selected
    $(".subjectRow").click(function() {
    	//$("#subjectCount").html('clicked subject row, going here ->' + $('a', this).attr('href'));	
    	window.location = $('a', this).attr('href');
    });
  
    $('.showSummary').html('Show Summary Table');
    $('.showSummary').click(function() {
		$(this).next().toggle('fast');
		if ($(this).hasClass("open")) {
			$(this).removeClass("open");
			$(this).addClass("closed");	
			$(this).html('Show Summary Table');
		} else {
			$(this).removeClass("closed");
			$(this).addClass("open");						
			$(this).html('Hide Summary Table');
		}
		return false;
	}).next().hide();    });
});

function showBlockEditForm() {
	$('body').css('overflow','hidden');
	$("#blockEditFormDialog").dialog("open");	
}

function closeBlockEditForm() {
	$('body').css('overflow','scroll');
	$("#blockEditFormDialog").dialog("close");	
}

function showStainEditForm() {
	$('body').css('overflow','hidden');
	$("#stainEditFormDialog").dialog("open");	
}

function closeStainEditForm() {
	$('body').css('overflow','scroll');
	$("#stainEditFormDialog").dialog("close");	
}

function showHideBlockInfo(e) {
	if (debug){
		alert('Clicked on element::' + e);		
	}
	if ($(e).hasClass("open")) {
		$(e).removeClass("open");
		$(e).addClass("closed");			
		$(e).next().hide('fast');			
	} else {
		$(e).removeClass("closed");
		$(e).addClass("open");						
		$(e).next().show('fast');			
	}
	return false;	
}

function removeBlockInfoDiv(blockId) {
	var elementId = '#block' + blockId;
	$(elementId).hide();	
}

function getElementIdx(elementId) {
	/**
	 * Evaluates an element id string,
	 * searches for the first underscore and
	 * returns any characters after the
	 * underscore.
	 */
	var start = elementId.indexOf('_') + 1;
	if (start >= 0) {
		return elementId.substring(start);		
	}
	return null;
}

function confirmDeleteBlock() {
	return confirm("Are you sure?");
}

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