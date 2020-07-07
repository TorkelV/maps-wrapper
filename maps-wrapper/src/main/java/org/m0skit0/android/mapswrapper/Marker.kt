package org.m0skit0.android.mapswrapper

class Marker internal constructor(
        internal val google: com.google.android.gms.maps.model.Marker?,
        internal val huawei: com.huawei.hms.maps.model.Marker?
) {

    var position: LatLng
        get() = google?.position?.let { LatLng(it.latitude, it.longitude) }
                ?: huawei?.position?.let { LatLng(it.latitude, it.longitude) }
                ?: throwUnableToResolveGoogleOrHuawei()
        set(value) {
            google?.position = value.google
            huawei?.position = value.huawei
        }

    var title: String
        get() = google?.title ?: huawei?.title ?: throwUnableToResolveGoogleOrHuawei()
        set(value) {
            google?.title = value
            huawei?.title = value
        }

    var snippet: String?
        get() = google?.snippet ?: huawei?.snippet
        set(value) {
            google?.snippet = value
            huawei?.snippet = value
        }

    var rotation: Float
        get() = google?.rotation ?: huawei?.rotation ?: throwUnableToResolveGoogleOrHuawei()
        set(value) {
            google?.rotation = value
            huawei?.rotation = value
        }

    val isInfoWindowShown: Boolean
        get() = google?.isInfoWindowShown ?: huawei?.isInfoWindowShown
        ?: throwUnableToResolveGoogleOrHuawei()

    var isFlat: Boolean
        get() = google?.isFlat ?: huawei?.isFlat ?: throwUnableToResolveGoogleOrHuawei()
        set(value) {
            google?.isFlat = value
            huawei?.isFlat = value
        }

    var zIndex: Float
        get() = google?.zIndex ?: huawei?.zIndex ?: throwUnableToResolveGoogleOrHuawei()
        set(value) {
            google?.zIndex = value
            huawei?.zIndex = value
        }

    var alpha: Float
        get() = google?.alpha ?: huawei?.alpha ?: throwUnableToResolveGoogleOrHuawei()
        set(value) {
            google?.alpha = value
            huawei?.alpha = value
        }

    var tag: Any?
        get() = google?.tag ?: huawei?.tag
        set(value) {
            google?.tag = value
            huawei?.tag = value
        }

    fun remove() {
        huawei?.remove()
        google?.remove()
    }

    fun setAnchor(x: Float, y: Float) {
        google?.setAnchor(x, y)
        huawei?.setMarkerAnchor(x, y)
    }

    fun setIcon(bitmapDescriptor: BitmapDescriptor) {
        google?.setIcon(bitmapDescriptor.google)
        huawei?.setIcon(bitmapDescriptor.huawei)
    }

    fun showInfoWindow() {
        google?.showInfoWindow() ?: huawei?.showInfoWindow()
    }
}
