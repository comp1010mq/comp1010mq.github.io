require 'victor'
require 'json'

class MemoryDiagramTag < Liquid::Tag
    def initialize(tag_name, input, tokens)
        super
        @input = input
    end

    def render(context)
        monoStyle = {"font-family": "Menlo, Monaco, Consolas, monospace"} 
        params = JSON.parse("{}")
        if(!@input.nil? && !@input.empty?)
            params = JSON.parse(@input)
        end
        svg = Victor::SVG.new template: :html, width: 600, height: 200
        xoff = 400
        yoff = 0
        sheight = 15;
        size = 20
        number = 10
        svg.build do
            # the code block
            sy = sheight;
            for s in params["code"].split("\n") do
                text s, x:0, y:sy, width: 100, height:100, style: monoStyle
                sy = sy + sheight;
            end
            for i in 0..number do
                line x1:xoff + i*size, y1:yoff, x2:xoff+i*size, y2:yoff+number*size, style: {stroke: '#000', stroke_width:1}
                line x1:xoff, y1:yoff+i*size, x2:xoff+number*size, y2:yoff + i*size, style: {stroke: '#000', stroke_width:1}
            end
            # look for filled cells
            for row in 0..number do
                for col in 0..number do
                    spotString = (row.to_s + col.to_s)
                    if (params[spotString])
                        text params[spotString], x:xoff+col*size, y: yoff+row*size + sheight, style: monoStyle
                    end
                end
            end
            # now go through the params and look for ones that are not above, they become arrows
            currslot = sheight
            for key in params do
                val = params[key]
                if (/\d\d/.match(key) || /code/.match(key))
                    next
                end
                # key goes as text, with arrow to other slot
                text key x:200, y: currslot, style: monoStyle
            end
        end
        return svg.render
    end
end
Liquid::Template.register_tag("memoryDiagram", MemoryDiagramTag)