[@includeTemplate name="navbar.ftl" /]
<script>
	$(function() {
	  $('#prender').click(function() {
	    $.ajax({
	      url: '/items-count',
	      cache:false
	    });
	  });
	});
	$(function() {
	  $('#high00').click(function() {
	    $.ajax({
	      url: '/high00',
	      cache:false
	    });
	  });
	});
	$(function() {
	  $('#low00').click(function() {
	    $.ajax({
	      url: '/low00',
	      cache:false
	    });
	  });
	});
</script>
<section class="content">
  <h4>Operaciones Raspberry PI</h4>
  <p class="text-center">
  	<a id="high00" class="btn btn-success btn-large btn-block">Prender led</a>
  </p>
	<p class="text-center">
  	<a id="prender" class="btn btn-large btn-block">Blink</a>
  </p>
  <p class="text-center">
  	<a id="low00" class="btn btn-danger btn-large btn-block">Apagar led</a>
  </p>
</section>

<div class="pageNote">
  <p>Información extraída con PI4J.</p>
</div>
  
