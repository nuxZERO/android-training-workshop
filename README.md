# android-training-workshop
Resource for android training workshop.

### Workshop 1
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

### Workshop 2
1. Build __Simple Toast__.
2. Build __Align Toast__.
3. Build __Custom Toast__.
4. Build __Simple Dialog__.
5. Build __Simple Dialog__.
6. Build __Progress Dialog__.
7. Build __List Dialog__.
8. Build __Single Choice Dialog__.
9. Build __Multiple Choices Dialog__.
10. Build __Date Picker Dialog__.
11. Build __Custom Content Dialog__.

### Workshop 3
1. `MainActivity.java` Delete hardcore coding
2. `activity_main.xml` Delete hardcore layout
3. `build.gradle` Add RecyclerView compile
4. `activity_main.xml` Insert RecyclerView
5. `MainActivity.java` Get RecyclerView
6. `MainActivity.java` Set layout manager
7. `PlaceAdapter.java` Make PlaceAdapter is subclass of RecyclerView.Adapter<PlaceViewHolder>
8. `PlaceAdapter.java` Create constructor
9. `PlaceAdapter.java` Create view for row from layout
10. `PlaceViewHolder.java` Make PlaceViewHolder is subclass of RecyclerView.ViewHolder
11. `PlaceViewHolder.java` Create fields
12. `PlaceViewHolder.java` Get view from `adapter_place` layout
13. `PlaceAdapter.java` Return number of rows in RecyclerView
14. `MainActivity.java` Set adapter
15. `PlaceAdapter.java` Bind view
16. `PlaceAdapter.java` Pass data
17. `PlaceAdapter.java` Pass Parcel object
18. `Place.java` Implement Parcelable
19. `DetailActivity.java` Get parcel object from intent
20. `DetailActivity.java` Bind views with place object
21. `activity_detail.xml` Wrap entry content with ScrollView
