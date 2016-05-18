//Backstretch
function backgroundimg(){
    $("#sandwich-month").backstretch(img_section2);
    $("#anhe").backstretch(img_section4);
    $("#grid-01").backstretch("images/bg-truck.jpg");
    $("#grid-02").backstretch("images/bg-party.jpg");
    $("#grid-03").backstretch("images/bg-press.jpg");
    $("#grid-04").backstretch("images/bg-fb2.jpg");
    $("#grid-05").backstretch("images/bg-instagram.jpg");
    $("#grid-06").backstretch("images/bg-picks.jpg");
}


function context_to_center(){

// $(".section__content .container").each(function(){
//     //alert($(this).html());
//     var win_h=$(window).height();
//     var container_h=$(this).height();
//     var padding_top=(win_h-container_h)/2;
    
//     $(this).css({"padding-top":padding_top+"px"});
    
    
// });

}
context_to_center();
backgroundimg();

//grids 

$("#grids--home a").on({
    mouseenter: function () {
        $(this).find("h4").animate({
		top: '0'
	});
    },
    mouseleave: function () {
        $(this).find("h4").animate({
		top: '-140'
	});
    }
});
$("#grids--home a").on({
    mouseenter: function () {
        $(this).find("i").animate({
		top: '0'
	});
    },
    mouseleave: function () {
        $(this).find("i").animate({
		top: '-140'
	});
    }
});


function gridsHome_img() {
    //directions.php 圖的縮放大小
    var window_w = $(window).width() + 15;
    if (window_w >= 767) {
    	$("#grids--home > div").each(function () {
    		var margin_w = $(this).find(".cs__container").css('margin-bottom');
            //alert(margin_w);
            margin_w = parseInt(margin_w, 10);
            var col_length = $(this).find(".cs__container").length;
            var diff_w = (window_w - (col_length - 1) * margin_w) / 12;
            var unit = 0;
            for (i = 0; i < col_length; i++) {
            	var limg = $(this).find(".cs__container").eq(i);
            	var cstr = limg.attr("class").split(" ");
            	cstr = cstr[0].split("-");
            	cstr = cstr[2];
            	var spw = 0;

            	if (cstr == 12) spw = margin_w * 3;
            	else if (cstr == 6) spw = 0;

            	var imgW = (diff_w * cstr + spw);
            	
            	if (i != (col_length - 1)) {
            		limg.css("margin-right", margin_w + "px");
            		limg.css("width", imgW + "px");
            	} else {
            		limg.css("width", imgW + "px");
            	}
                limg.find(".backstretch").css("width", "100%");
            	var libtn = $(this).find('.btn').width();
                //alert(libtn+' '+imgW);
                var libtnPosition = (imgW - (libtn+64))/2;

                $(this).find(".cs__container").eq(i).find('.btn').css({ 'left': libtnPosition + 'px' });

            }
        });
} else {
	var libtn = $(this).find('.btn').width();
	var libtnPosition = (window_w - (libtn+124))/2;
	$(".cs__container").css("width", "100%");
	$(".cs__container").find(".backstretch").css("width", "100%");
	$(".cs__container").find(".btn").css("left", libtnPosition+"px");
}
}
	//html5 grayscale
	// On window load. This waits until images have loaded which is essential
	$(window).load(function(){
		
		// Fade in images so there isn't a color "pop" document load and then on window load
		$("#grids--home .backstretch img").fadeIn(500);
		
		// clone image
		$('#grids--home .backstretch img').each(function(){
			var el = $(this);
			el.css({"position":"absolute"}).wrap("<div class='img_wrapper' style='display: inline-block'>").clone().addClass('img_grayscale').css({"position":"absolute","z-index":"998","opacity":"0"}).insertBefore(el).queue(function(){
				var el = $(this);
				el.parent().css({"width":this.width,"height":this.height});
				el.dequeue();
			});
			this.src = grayscale(this.src);
		});
		
		// Fade image 
		$('#grids--home .backstretch img').mouseover(function(){
			$(this).parent().find('img:first').stop().animate({opacity:1}, 1000);
		})
		$('.img_grayscale').mouseout(function(){
			$(this).stop().animate({opacity:0}, 2000);
		});		
	});
	
	// Grayscale w canvas method
	function grayscale(src){
		var canvas = document.createElement('canvas');
		var ctx = canvas.getContext('2d');
		var imgObj = new Image();
		imgObj.src = src;
		canvas.width = imgObj.width;
		canvas.height = imgObj.height; 
		ctx.drawImage(imgObj, 0, 0); 
		var imgPixels = ctx.getImageData(0, 0, canvas.width, canvas.height);
		for(var y = 0; y < imgPixels.height; y++){
			for(var x = 0; x < imgPixels.width; x++){
				var i = (y * 4) * imgPixels.width + x * 4;
				var avg = (imgPixels.data[i] + imgPixels.data[i + 1] + imgPixels.data[i + 2]) / 3;
				imgPixels.data[i] = avg; 
				imgPixels.data[i + 1] = avg; 
				imgPixels.data[i + 2] = avg;
			}
		}
		ctx.putImageData(imgPixels, 0, 0, 0, 0, imgPixels.width, imgPixels.height);
		return canvas.toDataURL();
	}
$(document).ready(function() {
	gridsHome_img();
	$('#slides, #whats-hot').superslides({
		play: 4000
	});
});
var isresize;
$(window).resize(function() {
	gridsHome_img();
	clearTimeout(isresize);
	isresize=setTimeout(function(){
    	backgroundimg();
    	context_to_center();
	}, 500)
});

$(".scroll-down span").click(function() {
    $('html, body').animate({
        scrollTop: $("#whats-hot").offset().top
    }, 1000);
});

