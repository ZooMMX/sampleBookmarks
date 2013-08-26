[@includeTemplate name="navbar.ftl" /]
<script>
	$(function() {
	  $('#prender').click(function() {
	    $.ajax({
	      success: function() { alert('ok'); },
	      error: function(){ alert('fail'); },
	      url: '/items-count',
	      cache:false
	    });
	  });
	});
</script>
<section class="content">
  <h4>Operaciones Raspberry PI</h4>
  <p class="text-center">
  	<a id="prender" class="btn btn-success btn-large btn-block" href="#">Prender led</a>
  </p>
	<p class="text-center">
  	<a class="btn btn-large btn-block" href="¢">Blink</a>
  </p>
  <p class="text-center">
  	<a class="btn btn-danger btn-large btn-block" href="¢">Apagar led</a>
  </p>
</section>

<div class="pageNote">
  <p>Información extraída con PI4J.</p>
</div>
  
