<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld page</title>
    <script type="text/javascript" src="https://public.tableau.com/javascripts/api/tableau-2.js"></script>
	<script type="text/javascript">
        function initViz() {
        	console.log("------------Inside viz ");
        	var greeting = "${greeting}";
        	console.log("------------ " + greeting);
            var containerDiv = document.getElementById("vizContainer"),
              //  url = "http://public.tableau.com/views/RegionalSampleWorkbook/Storms",
               //url= "https://10az.online.tableau.com/trused/" + greeting + "/t/patest/views/AnalyzeSuperstore/Overview?:embed=y&:showShareOptions=true&:display_count=no&:showVizHome=no",
            		   url= "https://10az.online.tableau.com/trused/" + greeting + "/t/patest/views/AnalyzeSuperstore/Overview?:embed=y&:showShareOptions=true&:display_count=no&:showVizHome=no",
                options = {
                    hideTabs: true,
                    onFirstInteractive: function () {
                        console.log("Run this code when the viz has finished loading.");
                    }
                };
            
            console.log("------------ " + url);
            
            // Create a viz object and embed it in the container div.
            var viz = new tableau.Viz(containerDiv, url, options); 
        }
    </script>
</head>
</head>
<body onload="initViz();">
	
	greeting =  ${greeting};
	
    <div id="vizContainer" style="width:800px; height:700px;"></div>    
</body>
</html>