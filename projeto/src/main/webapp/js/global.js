 
//typekit
function() {
	var config = {
		kitId: 'yjq7foi',
		scriptTimeout: 3000
	};
	var h=document.getElementsByTagName("html")[0];h.className+=" wf-loading";var t=setTimeout(function(){h.className=h.className.replace(/(\s|^)wf-loading(\s|$)/g," ");h.className+=" wf-inactive"},config.scriptTimeout);var tk=document.createElement("script"),d=false;tk.src='//use.typekit.net/'+config.kitId+'.js';tk.type="text/javascript";tk.async="true";tk.onload=tk.onreadystatechange=function(){var a=this.readyState;if(d||a&&a!="complete"&&a!="loaded")return;d=true;clearTimeout(t);try{Typekit.load(config)}catch(b){}};var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(tk,s)
})();

var menuopen=0;	
var menulef=parseInt($('.menu-wrapper').css("left"));

//menu
$('.menu-wrapper').css({
	'left':'0px'
});
$('.menu-icon').css({
	'left':'-40px'
});
 //http://kirafugames.blogspot.tw/2012/10/jquery-callbackfirefoxbug.html
 	var w_width=$(window).width();
 	var def_w=160;
 	if(w_width<640)
 		def_w=500;
 		 
 if(w_width<640)
 {

     var menulef=parseInt($('.menu-wrapper').css("left"));
         			if(menulef==0)
         			{
         				$('.menu-wrapper').stop().animate({
         					'left':-def_w+'px'
         				},{
         					complete: function() {
         						menulef=parseInt($('.menu-wrapper').css("left"));
         						if(menulef==-def_w)
         						{
         							$('.menu-icon').animate({
         								'left':'0'
         							});	
         						}

         					}

         				});
         			}
         			
         			

 }
 
 
 $(document).scroll(function(){
 	var y = $(window).scrollTop();
 	var x = 5;//$('#intro').height()/2;
 	var w_width=$(document).width();
 	var def_w=160;
 	if(w_width<640)
 		def_w=100;
 			// alert(def_w);
 			if(menuopen==0&&w_width>640)
 			{
 				if( y ==0)
 				{
 					var menulef=parseInt($('.menu-wrapper').css("left"));
 					
 					if(menulef==-def_w)
 					{
 						$('.menu-icon').stop().animate({
 							'left':(-def_w)+'px'
 						},{
 							complete: function() {
 								menulef=parseInt($('.menu-icon').css("left"));
         						//$('.menu-wrapper').css({'left':'0px'});
         						if(menulef==-def_w)
         						{
         							$('.menu-wrapper').animate({
         								'left':-def_w
         							});	
         						}

         					}

         				});
 					}
 				}
 				else if( y > x){
         			//å¤§æ–¼intro

         			var menulef=parseInt($('.menu-wrapper').css("left"));
         			if(menulef==0)
         			{
         				$('.menu-wrapper').stop().animate({
         					'left':-def_w+'px'
         				},{
         					complete: function() {
         						menulef=parseInt($('.menu-wrapper').css("left"));
         						if(menulef==-def_w)
         						{
         							$('.menu-icon').animate({
         								'left':'0'
         							});	
         						}

         					}

         				});
         			}

         		} else {}

         	}
         })



 $(".language-select").click(function() {
 	$(".language__selection").fadeToggle("slow", "linear");
 });
 $(".wrapper").click(function() {
 	$(".language__selection").hide();
 });
 (function ($) {
 	$.fn.toggleClick = function () {
 		var methods = arguments,
			// store the passed arguments for future reference
			count = methods.length; // cache the number of methods 
		//use return this to maintain jQuery chainability
		return this.each(function (i, item) {
			// for each element you bind to
			var index = 0; // create a local counter for that element
			$(item).click(function () { // bind a click handler to that element
				return methods[index++ % count].apply(this, arguments); // that when called will apply the 'index'th method to that element
				// the index % count means that we constrain our iterator between 0 and (count-1)
			});
		});
	} //end toggleClick
	
	$.fn.slideBar = function (options) {
		var settings = $.extend({
			element: '.wrapper',
			divWidth: null,
			iconOpen: 'icon-menu',
			iconClose: 'icon-cancel'
		}, options);
		return this.each(function () {
			$('.menu-wrapper').css({
				'right': '-' + settings.divWidth,
				'width': settings.divWidth
			});
			$(this).toggleClick(

				function (event) {
					menuopen=1;
					event.preventDefault();
					$(settings.element).addClass('active').animate({
						'left': settings.divWidth + 'px'
					}, 100);
					$('.menu-wrapper').animate({
						'left': '0px'
					}, 100);
					$(this).animate({
						'left': settings.divWidth + 'px'
					}, 100);
					var windowWidth = $(window).width();
					$(this).find('i').removeClass().addClass(settings.iconClose);
				}, function (event) {
					menuopen=0;
					event.preventDefault();
					$(settings.element).removeClass('active').animate({
						'left': '0px'
					}, 100);
					$('.menu-wrapper').animate({
						'left': "-" + settings.divWidth + 'px'
					}, 100);

					$(this).animate({
						'left': '0px'
					}, 100);
					$(this).find('i').removeClass().addClass(settings.iconOpen);
					var windowWidth = $(window).width();
			}); //on click
		}); //each
	} //end slideBar
}(jQuery));

 $(document).ready(function() {
 	var w_width2=$(document).width();
 	var def_w2=160;
 	if(w_width2<640)
 		def_w2=100;
 	$(".mainmenuDrop").navgoco({
 		accordion: true
 		// save: false
 	});
	//left sidebar (slide to left)
	$('.menu-icon').slideBar({
		element: '.wrapper',
		divWidth: def_w2,
	});
	$('.bread-crumb a:last-child').addClass('last-bread');
	if ($(".nav--drop").hasClass('open')) {
		$('.open').find(".icon-plus").removeClass('icon-plus').addClass('icon-minus');
	}
});
 $(".nav--drop >a").click(function() {
 	$(".nav--drop >a i").attr('class','icon-plus');
 	setTimeout(function(){
 		$('.open').find(".icon-plus").removeClass('icon-plus').addClass('icon-minus');
 	},10);
 });
 
 
 function mailer_reg(){
 	var mail=$('#mailer').val();

 	var atpos=mail.indexOf("@");
 	var dotpos=mail.lastIndexOf(".");
 	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=mail.length)
 	{
 		alert("è«‹è¼¸å…¥æ­£ç¢ºä¿¡ç®±æ ¼å¼�");
 		return false;
 	}
 	else
 	{
 		$.ajax({
 			url: 'home/mailer',
 			cache: false,
 			dataType: 'html',
 			type:'post',
 			data: {mailer:mail},
 			error: function(xhr) {
 				alert('Ajax request ç™¼ç”ŸéŒ¯èª¤');
 			},
 			success: function(response) {
 				alert(response);
 			}
 		});	
 	}
 }
 