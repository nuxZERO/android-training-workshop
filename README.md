# android-training-workshop
Resource for android training workshop.

### MyApplication
1. Create `ImageView` id `@+id/photo_image`
2. Copy image file to `drawable` directory and set image
3. Create `TextView` id `@+id/title_text` and set text
4. Create `TextView` id `@+id/subtitle_text` and set text
5. Create `EditText` id `@+id/message_input` and set hint
6. Create `Button` id `@+id/send_message_button` and set text
7. Connect reference views in `MainActivity`.
8. Copy other image set to `ImageView`.
9. Set `TextView`s.
10. Set click event for `Button`.
11. Get text from `EditText` to show message popup.
12. Add `RelativeLayout`.
13. Align views in `RelativeLayout`.
14. Create new `Activity` name `SecondActivity`.
15. Open `AndroidManifest.xml` set parent activity for `SecondActivity`.
16. Create `Intent` and send message to `SecondActivity`.
17. Get intent data in `SecondActivity`.
18. Add `TextView` id `@+id/message_text`.
19. Set receive message to `TextView`.
20. Add `Logging`.
21. Add `Breakpoint` and run in __debug mode__.
22. Complete workshop1.

## Workshop1

### TODO 01
```java
Uri gmmIntentUri = Uri.parse("google.navigation:q=16.8405744,100.2313737&mode=d");
Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
mapIntent.setPackage("com.google.android.apps.maps");
startActivity(mapIntent);
```
