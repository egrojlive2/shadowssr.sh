
    const v0, 0x7f0700b3

    invoke-virtual {p0, v0}, Lcom/example/prueba2/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    iput-object v0, p0, Lcom/example/prueba2/MainActivity;->vid:Landroid/widget/VideoView;




    iget-object v0, p0, Lcom/example/prueba2/MainActivity;->vid:Landroid/widget/VideoView;

    new-instance v1, Lcom/example/prueba2/MainActivity$1;

    invoke-direct {v1, p0}, Lcom/example/prueba2/MainActivity$1;-><init>(Lcom/example/prueba2/MainActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V
