(this["webpackJsonpreact-frontend"]=this["webpackJsonpreact-frontend"]||[]).push([[0],{173:function(e,t,n){},203:function(e,t,n){e.exports=n(362)},208:function(e,t,n){},209:function(e,t,n){},358:function(e,t,n){},360:function(e,t,n){},362:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),l=n(25),o=n.n(l),c=(n(208),n(209),n(41)),s=n(169),i=n(27),u=n(28),m=n(39),d=n(38),h=n(37),f=n(376),p=n(373),b=n(377),g=n(375),v=n(170),E=n(57),y=n.n(E),k=(n(222),n(173)),C=n.n(k),O=function(e){Object(d.a)(n,e);var t=Object(h.a)(n);function n(e){var a;return Object(i.a)(this,n),(a=t.call(this,e)).state={username:"",password:"",error:!1},a.handleChange=a.handleChange.bind(Object(m.a)(a)),a.onSubmit=a.onSubmit.bind(Object(m.a)(a)),a}return Object(u.a)(n,[{key:"componentDidMount",value:function(){document.body.style.backgroundImage='url("https://usersnap.com/blog/wp-content/uploads/2017/04/web-design-background.png")'}},{key:"onSubmit",value:function(e){e.preventDefault();var t=this.state,n=t.username,a=t.password;if(this.setState({error:!1}),"admin"!==n||"pythonsucks"!==a)return this.setState({error:!0});console.log("you're logged in. yay!"),y.a.set("loggedIn",!0),this.props.history.push("/home")}},{key:"handleChange",value:function(e,t){var n=t.name,a=t.value;this.setState(Object(s.a)({},n,a))}},{key:"render",value:function(){var e=this.state.error;return r.a.createElement("div",{className:"bgImg"},r.a.createElement("div",null,r.a.createElement(f.a,null,r.a.createElement(v.a,null,r.a.createElement("title",null,"SES | Login")),r.a.createElement(f.a.Column,{width:6}),r.a.createElement(f.a.Column,{width:4},r.a.createElement(p.a,{className:C.a.loginForm,error:e,onSubmit:this.onSubmit},r.a.createElement(b.a,{as:"h1"},"Login"),e&&r.a.createElement(g.a,{error:e,content:"Incorrect Credentials !!"}),r.a.createElement(p.a.Input,{inline:!0,label:"Username",name:"username",onChange:this.handleChange}),r.a.createElement(p.a.Input,{inline:!0,label:"Password",type:"password",name:"password",onChange:this.handleChange}),r.a.createElement(p.a.Button,{type:"submit"},"Go!"))))))}}]),n}(r.a.Component),j=function(e){Object(d.a)(n,e);var t=Object(h.a)(n);function n(){return Object(i.a)(this,n),t.apply(this,arguments)}return Object(u.a)(n,[{key:"render",value:function(){return r.a.createElement("div",{class:"container"},r.a.createElement("div",{class:"page-header",style:{backgroundColor:"#076161",color:"#ffffff",padding:"10px",textAlign:"center",borderRadius:"25px"}},r.a.createElement("h1",null,"SES Project Demo")))}}]),n}(a.Component),w=n(115),A=n.n(w),S="".concat("https://ses-project-bitsme.herokuapp.com/api","/alert"),I=new(function(){function e(){Object(i.a)(this,e)}return Object(u.a)(e,[{key:"retrieveAllAlerts",value:function(){return A.a.get("".concat(S,"/all"))}},{key:"deleteAlert",value:function(e){var t=A.a.delete("".concat(S,"/").concat(e));return console.log(t),t}}]),e}()),D=n(65),N=(n(358),n(21)),x=Object(N.a)(),B=function(e){Object(d.a)(n,e);var t=Object(h.a)(n);function n(e){var a;return Object(i.a)(this,n),(a=t.call(this,e)).state={alerts:[],count:0},a.refreshAlerts=a.refreshAlerts.bind(Object(m.a)(a)),a.deleteAlertClicked=a.deleteAlertClicked.bind(Object(m.a)(a)),a}return Object(u.a)(n,[{key:"componentDidMount",value:function(){this.refreshAlerts(),this.interval=setInterval(this.refreshAlerts,2e3)}},{key:"refreshAlerts",value:function(){var e=this;I.retrieveAllAlerts().then((function(t){e.setState({alerts:t.data})}));var t=this.state.alerts[this.state.alerts.length-1];if(this.state.alerts.length>0){if(this.state.count<t.id&&0!=this.state.count)for(var n=this.state.count+1;n<=t.id;n++)D.b.error("New alert "+"".concat(n)+" @ "+"".concat(t.createdAt),{position:"top-right",autoClose:5e3,hideProgressBar:!0,closeOnClick:!0,pauseOnHover:!0,draggable:!0});this.setState({count:t.id})}}},{key:"deleteAlertClicked",value:function(e){var t=this;I.deleteAlert(e).then((function(n){D.b.success("\ud83d\uddd1\ufe0f Deleted alert "+"".concat(e),{position:"top-right",autoClose:5e3,hideProgressBar:!0,closeOnClick:!0,pauseOnHover:!0,draggable:!0}),t.refreshAlerts()}))}},{key:"handleLogout",value:function(){y.a.remove("loggedIn"),x.push("/"),window.location.reload(!1)}},{key:"componentWillUnmount",value:function(){clearInterval(this.interval)}},{key:"render",value:function(){var e=this;return r.a.createElement("div",null,r.a.createElement("div",{class:"container",style:{marginTop:"20px"}},r.a.createElement("div",{class:"row"},r.a.createElement("div",{class:"col-sm"},r.a.createElement("h4",null,"All Alerts")),r.a.createElement("div",{class:"col-sm"}),r.a.createElement("div",{class:"col-sm"},r.a.createElement("button",{className:"btn btn-warning float-right",onClick:function(){return e.handleLogout()}},"Logout")))),r.a.createElement("div",{className:"container",style:{marginTop:"20px"}},r.a.createElement("table",{className:"table"},r.a.createElement("thead",null,r.a.createElement("tr",null,r.a.createElement("th",{style:{backgroundColor:"#092445",color:"#ffffff"}},"ID"),r.a.createElement("th",{style:{backgroundColor:"#092445",color:"#ffffff"}},"Description"),r.a.createElement("th",{style:{backgroundColor:"#092445",color:"#ffffff"}},"Timestamp"),r.a.createElement("th",{style:{backgroundColor:"#092445",color:"#ffffff"}}))),r.a.createElement("tbody",null,this.state.alerts.map((function(t){return r.a.createElement("tr",{key:t.id},r.a.createElement("td",null,t.id),r.a.createElement("td",null,t.desc),r.a.createElement("td",null,t.createdAt),r.a.createElement("td",null,r.a.createElement("button",{className:"btn btn-danger",onClick:function(){return e.deleteAlertClicked(t.id)}},"Delete")))}))))))}}]),n}(a.Component),L=(n(359),n(360),function(e){Object(d.a)(n,e);var t=Object(h.a)(n);function n(){return Object(i.a)(this,n),t.apply(this,arguments)}return Object(u.a)(n,[{key:"componentDidMount",value:function(){!0!==y.a.get("loggedIn")&&this.props.history.push("/"),document.body.style.backgroundImage="none"}},{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement(j,null),r.a.createElement(B,null),r.a.createElement(D.a,{position:"top-right",autoClose:5e3,hideProgressBar:!0,newestOnTop:!0,closeOnClick:!0,rtl:!1,pauseOnVisibilityChange:!0,draggable:!0,pauseOnHover:!0}))}}]),n}(a.Component));var P=function(){return r.a.createElement("div",{className:"App"},r.a.createElement("div",{className:"app-routes"},r.a.createElement(c.c,null,r.a.createElement(c.a,{exact:!0,path:"/",component:O}),r.a.createElement(c.a,{path:"/home",component:L}))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var M=n(110);o.a.render(r.a.createElement(r.a.StrictMode,null,r.a.createElement(M.a,null,r.a.createElement(P,null))),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[203,1,2]]]);
//# sourceMappingURL=main.c8314f1b.chunk.js.map