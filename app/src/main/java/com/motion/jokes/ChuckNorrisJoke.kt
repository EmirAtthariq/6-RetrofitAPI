package com.motion.jokes

// Define a data class as ChuckNorrisJoke
data class ChuckNorrisJoke(
    // Property that consist the categories
    var categories: ArrayList<String>,
    // Property that consist the date and time
    var created_at: String,
    // Property that contains the URL of the icon
    var icon_url: String,
    // Property that contains the ID
    var id: String,
    // Property that contains the date and
    // time when the joke is updated
    var updated_at: String,
    // Property that contains the URL
    // of the joke as a string
    var url: String,
    // Property that contains the
    // actual joke as a string
    var value: String
)
