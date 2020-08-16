.class public Lcom/d2rey/ang/ui/MainActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "MainActivity.java"


# instance fields
.field vid:Landroid/widget/VideoView;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 10
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 14
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 15
    const v0, 0x7f0a001c

    invoke-virtual {p0, v0}, Lcom/d2rey/ang/ui/MainActivity;->setContentView(I)V

    .line 20
    const v0, 0x7f0700b3

    invoke-virtual {p0, v0}, Lcom/d2rey/ang/ui/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    iput-object v0, p0, Lcom/d2rey/ang/ui/MainActivity;->vid:Landroid/widget/VideoView;

    .line 21
    iget-object v0, p0, Lcom/d2rey/ang/ui/MainActivity;->vid:Landroid/widget/VideoView;

    new-instance v1, Lcom/d2rey/ang/ui/MainActivity$1;

    invoke-direct {v1, p0}, Lcom/d2rey/ang/ui/MainActivity$1;-><init>(Lcom/d2rey/ang/ui/MainActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 27
    iget-object v0, p0, Lcom/d2rey/ang/ui/MainActivity;->vid:Landroid/widget/VideoView;

    invoke-virtual {p0, v0}, Lcom/d2rey/ang/ui/MainActivity;->playVideo(Landroid/view/View;)V

    .line 28
    return-void
.end method

.method protected onResume()V
    .registers 2

    .prologue
    .line 32
    iget-object v0, p0, Lcom/d2rey/ang/ui/MainActivity;->vid:Landroid/widget/VideoView;

    invoke-virtual {p0, v0}, Lcom/d2rey/ang/ui/MainActivity;->playVideo(Landroid/view/View;)V

    .line 33
    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onResume()V

    .line 34
    return-void
.end method

.method public playVideo(Landroid/view/View;)V
    .registers 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 41
    const-string v0, "android.resource://com.soyrojo/2131099745"

    .line 42
    .local v0, "path":Ljava/lang/String;
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 44
    .local v1, "u":Landroid/net/Uri;
    iget-object v2, p0, Lcom/d2rey/ang/ui/MainActivity;->vid:Landroid/widget/VideoView;

    invoke-virtual {v2, v1}, Landroid/widget/VideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 46
    iget-object v2, p0, Lcom/d2rey/ang/ui/MainActivity;->vid:Landroid/widget/VideoView;

    invoke-virtual {v2}, Landroid/widget/VideoView;->start()V

    .line 48
    return-void
.end method
