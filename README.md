#Ti.Moblyft

Titanium module for Moblyft.
<img src="https://scontent-fra3-1.xx.fbcdn.net/t31.0-8/13416983_1583955851897513_6730517565621884363_o.jpg" width=600 />

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