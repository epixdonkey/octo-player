# Changelog

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
