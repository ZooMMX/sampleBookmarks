<div id="pageNav" class="navbar navbar-inverse navbar-static-top">
  <div class="navbar-inner">
    <a class="brand" href="${_r.contextPath}">Porto-tron</a>
    <ul class="nav">
      <li class="[#if piIs("/operaciones")]active[/#if]"><a href="operaciones">Operaciones Raspberry</a></li>
      <li class="[#if piIs("/info")]active[/#if]"><a href="info">Información Raspberry</a></li>

    </ul>
    <div id="userInfo">
      <label>[#if _r.user??]${_r.user.fullName!"no full name"}[/#if] <a class="logoff">(logoff)</a></label>
      
      
    </div>
  </div>
</div>

