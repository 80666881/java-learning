<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<style>
.codeodd {
	background-color: #f0f0f0;
}

.codeeven {
	background-color: #d1d1d1;
}

div.code {
	width: 80%;
	border: 1px #aaa solid;
}
</style>
<script src="http://192.168.1.189/study/jquery.min.js"></script>

<script>
	$(function() {
		$("div.code").each(function() {
			var div = this;
			var html = $(this).html();
			var lines = html.split("<br>");
			console.log(html);
			console.log(lines);
			$(this).html("");

			$.each(lines, function(i, n) {
				var li = document.createElement("div");
				var text = document.createTextNode(n);
				li.appendChild(text);

				var classAttr = document.createAttribute("class");
				if (0 == i % 2)
					classAttr.nodeValue = "codeodd";
				if (1 == i % 2)
					classAttr.nodeValue = "codeeven";
				li.setAttributeNode(classAttr);

				div.appendChild(li);
			})
		});

	});
</script>

<div class="code">
	fsd <br> fs<br> fs<br> f<br> sf<br> sf<br>
</div>