Vue.component('header-component', {
    template: `<div class="faveHeader-limiter">
      <h1><img src="Logo/logo.png" width="70"></h1>
      <nav class="headerNav">
        <a href="index.html"><i></i>Home</a>
        <a href="about.html"><i></i>About</a>
        <a href="javascript:void();"><i></i>Kontakt</a>
      </nav>
      <ul>
      <li><button class="draw draw-nav" href="#">Sign up</a></button></li>
      <li><button class="draw draw-nav" href="#">Login</a></button></li>
      </ul>
    </div>`
  })
  
  var app = new Vue({
    el: '#header',
    data: function () {
      return {}
    }
  })