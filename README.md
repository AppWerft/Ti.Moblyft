#Ti.Moblyft

work in progress

##Usage
```javascript
var Ad = require("ti.moblyft");

Ad.initSDK({
	appKey : "APPKEY",
	userId : "USERID"
})
if (Ad.isAdAvailable()) {
	Ad.showAd();
}
```

tiapp.xml
```xml
<property name="MOBLYFT_APPKEY" type="string">xxxx</property>
<property name="MOBLYFT_USERID" type="string">xxxx</property>
```