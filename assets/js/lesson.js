// basics of memory diagrams
var monoStyle = {"font-family": "Menlo, Monaco,Consolas, monospace"};
var blackStyle = {stroke:"black"};
function memGrid(svg, size=20, xoff=10, yoff=10){
  for(var i = 0; i <= size*10; i += size){
    svg.line(xoff+i, yoff, xoff+ i, yoff+size*10).attr({stroke:"black"});
    svg.line(xoff, yoff+i, xoff+size*10, yoff+i).attr({stroke: "black"});
  }
}

function memDiag(parent, width=10, height=10){
    var table = $("<table/>");
    for(var i = 0; i< width; i++){
        var row = $("<tr/>");
        for(var j = 0; j < height; j++){
          row.append($("<td/>")
             .attr("id", "mem_"+i+"_"+j)
             .addClass("memCell"));
        }
        table.append(row);
    } 
    $(parent).append(table);
    return table;
}
