<script>
// Slideshow with granular control
var slides = [     
  { url: '/img/slides/children-pray-candelight.jpg', id:'spirit_of_the_lord', alt:'spirit_of_the_lord'},
  { url: '/img/slides/relief team leader.jpg', id:"good_news", alt:"good_news" },
  { url: '/img/slides/families run across the road.jpg', id:"freedom", alt:'freedom'},
  { url: '/img/slides/Grand Teton.jpeg', id:"sight", alt:"sight" },
  { url: '/img/slides/eliya_first_ranger.jpg',id:"set_oppressed_free", alt:"set_oppressed_free" },
  { url: 'img/slides/DERescuesGirlMosul2017.JPG', id:"FTO", alt:'FTO', duration:8000},
  { url: '/img/slides/black.png', id:'black', alt:'FTO'}
]


var slideCaptions = [
                     
      {id: 'spirit_of_the_lord', caption:"The Spirit of the Lord<br/> is upon me"},
      {id: 'good_news', caption:"To proclaim good news <br/>to the poor"},
      {id: 'freedom', caption:"To proclaim freedom<br/> for the prisoners"},
      {id: 'sight', caption:"And recovery of sight <br/> for the blind"},
      {id: 'set_oppressed_free', caption:"To set the oppressed free"},
      {id: 'FTO', caption:"Free The Oppressed"}
      ]
                     
$('div.slide-container').backstretch(slides, {duration:7000,fade:4000});                     

$(function(data){
        var date = new Date();
        $("#date-stamp").html("<p>Time is: " + date);
        
        var caption = slideCaptions[0];
        switchCaption(caption.caption);
        
        $(window).on("backstretch.before", function (e, instance, idx) {
  			//get the caption
  			var slide = slides[idx];
  			var id = slide.id;
  			var caption = slideCaptions.filter(function(caption){
  			    return caption.id === id;
  			});
  			//debugger;
  			if(caption.length) switchCaption(caption[0].caption);
  		});
  		

});

function switchCaption(captionText){
	var $cap = $("div.caption-container");
	$cap.fadeOut(1500, complete);

	function complete(){
	    $cap.html(captionText).fadeIn(2500);
	}
}

</script>
