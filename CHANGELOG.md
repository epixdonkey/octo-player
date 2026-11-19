# Changelog

## 2026.11.19 — The fork goes dormant: his app does it all

### 1. The fleet flies the developer's own app; this fork becomes a drawer (`chore`)

With the fleet's server carrying `octoPlaylistSongs` — upstream's own held
playlists, migrated in place under the same ids — the developer's app
1.13.0 does everything the patched app was kept for: songs found online go
into playlists, downloads land and bind, and the stations the fleet's
server still carries (YouTube Music rows without a Last.fm key, live
radio, the playlist download doors, family playlists) reach the phone
through his app unchanged, because the server serves them. The fleet now
installs his app from his own releases. This fork stays as a drawer: its
working branch is `dev`, like the server's, and the day his app breaks or
lags behind a needed fix, one merge and one build bring the patched app
back.

### 2. Beside the official "Octo", the fleet's build reads "Octo - dev" (`build(app)`)

Two Octos on one launcher are told apart at a glance now: the patched
build type carries its own label overlay
(`app/src/patched/res/values/strings.xml`). Nothing else changes — the
file stays `Octo-patched.apk` under the same `patched-latest` tag, and
the version lives inside the APK.

### 3. The APK builds on order alone (`ci`)

The push trigger is gone from `patched-build.yml`: a `workflow_dispatch`
is the only way a build starts. The fleet's law always said the APK
builds when ordered, never because a branch or a document moved — now
the workflow says it too.

## 2026.11.17 — Upstream apps 1.13.0: the fork's playlist patch retires

### 1. Everything upstream apps 1.13.0, and the developer's own songs found online in playlists in place of this fork's patch (`chore`)

Upstream 1.13.0 brings, natively, the feature this fork first patched onto
1.11.0: songs found online going into your playlists, from a song's menu, a
selection and a saved queue. Upstream does it better than the patch did —
a find keeps its place once its download lands, a playlist changed on two
devices keeps both sides, a phone-only playlist holding finds saves itself
to the server, and the adds appear only when your server says it keeps them
(Octo server 2026.11.15 or newer). By this fork's rule — the developer's
code wins wherever he has done it, better or only begun to — the patch
retires whole: every file it touched now carries upstream's code and
upstream's tests, and nothing of the fork's playlist work remains.

### 2. The fork's channel stays: the `.patched` build, its key, its CI (`build(app)`, `ci`)

What survives the merge is everything upstream has nothing to do with: the
`.patched` build type — this fork's own app beside the official one
(`app.winters.octo.patched`), signed with the fork's stable key so one
update installs over the last, its self-updater asleep — and the workflow
that builds and tests every push and publishes each green build as an APK
on Releases, early access to each upstream release.

### 3. The README's fork block and this CHANGELOG (`docs`)

The README gains the fork's block at the very top, stating the rule this
fork runs by: stay as close to upstream as possible, the developer's code
first, the fork's own changes only ever filling a gap upstream has not
reached yet — when his version lands, the fork's patch for it retires, as
this publication shows. Each publication of the fork records its changes
here, in the server fork's CHANGELOG shape.
