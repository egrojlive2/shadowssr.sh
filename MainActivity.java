vid=(VideoView)findViewById(R.id.vid);
		vid.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
			@Override
			public void onCompletion(MediaPlayer p1){
				vid.start();
			}
		});



playVideo(vid);


public void playVideo(View v) {
        //MediaController m = new MediaController(this);
		
        //vid.setMediaController(m);

        String path = "android.resource://com.soyrojo/"+R.drawable.mp4;
        Uri u = Uri.parse(path);

        vid.setVideoURI(u);

        vid.start();

    }
