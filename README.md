#Ti.Moblyft

work in progress

##Usage
```javascript
var Ad = require("ti.moblyft");

Ad.initSDK({
		appKey : "APPKEY", // optional, you can use entry in tiapp.xml
		userId : "USERID" // optional, you can use entry in tiapp.xml
	}, 
	onResult : function() {
		console.log("OK");
	}
)
if (Ad.isAdAvailable()) {
	Ad.showAd(function(res){
		console.log(res);
	});
}
```

tiapp.xml
```xml
<property name="MOBLYFT_APPKEY" type="string">xxxx</property>
<property name="MOBLYFT_USERID" type="string">xxxx</property>
```