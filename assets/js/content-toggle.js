// Clicking a element with the content-toggle class with toggle
// the next element with the collapsible-content class.
$(".content-toggle").click(function(){
	$(this).next(".collapsible-content").toggle();
});
