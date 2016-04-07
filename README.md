# android-training-workshop
Resource for android training workshop.

```java
Uri gmmIntentUri = Uri.parse("google.navigation:q=16.8405744,100.2313737&mode=d");
Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
mapIntent.setPackage("com.google.android.apps.maps");
startActivity(mapIntent);
```
