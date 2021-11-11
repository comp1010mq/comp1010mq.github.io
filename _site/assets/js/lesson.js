$(document).ready(function(){
    // Make all tables striped by default.
    $("table").addClass("table table-striped");


    // Handle foldable challenges and solutions (on click and at start).
    $("blockquote.solution, div.solution").click(function(event) {
        console.log("solution was clicked");
        $(">*:not(h2)", this).toggle(400);
        event.stopPropagation();
    });
    $("blockquote.solution, div.solution").each(function() {
        console.log("folding solution at start");
        $(">*:not(h2)", this).toggle()
        $(this).children("h2").css("cursor", "pointer");
    });

    // handle foldable menu items
    $(".disclosure").click(function(event){
        console.log("some disclosure item was clicked");
        $(">*", this).toggle()
        event.stopPropagation();
    });
    $(".disclosure >*").click(function(event){
        event.stopPropagation();
    });


    // Handle searches.
    // Relies on document having 'meta' element with name 'search-domain'.
    function google_search() {
    var query = document.getElementById("google-search").value;
    var domain = $("meta[name=search-domain]").attr("value");
    window.open("https://www.google.com/search?q=" + query + "+site:" + domain);
    }
});

// basics of memory diagrams
var monoStyle = {"font-family": "Menlo, Monaco,Consolas, monospace"};
var blackStyle = {stroke:"black"};
function memGrid(svg, size=20, xoff=10, yoff=10){
  for(var i = 0; i <= size*10; i += size){
    svg.line(xoff+i, yoff, xoff+ i, yoff+size*10).attr({stroke:"black"});
    svg.line(xoff, yoff+i, xoff+size*10, yoff+i).attr({stroke: "black"});
  }
}

