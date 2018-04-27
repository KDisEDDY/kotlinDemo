package project.ljy.kotlindemo.data

import java.io.Serializable

/**
 * Title: VideoList
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/3/31
 * Version: 1.0
 */

class VideoList : Serializable {

    var count: Int = 0
    var total: Int = 0
    var nextPageUrl: String? = null
    var isAdExist: Boolean = false
    var date: Long = 0
    var nextPublishTime: Long = 0
    var dialog: Any? = null
    var topIssue: Any? = null
    var refreshCount: Int = 0
    var lastStartId: Int = 0

    var itemList: List<ItemList>? = null

    class ItemList {
        var type: String? = null
        /**
         * dataType : VideoBeanForClient
         * id : 94059
         * title : 如何解除「加班」魔咒？
         * description : 以按时回家为目的的「回家改革部」今日建成，各式招数帮你解除加班魔咒！手段是另一回事，最重要的是要有一个回家的理由啊～让你还未上班就想下班的动力又是什么呢？From KDDI株式会社
         * library : DAILY
         * tags : [{"id":748,"name":"广告精选","actionUrl":"eyepetizer://tag/748/?title=%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT"},{"id":384,"name":"日本广告","actionUrl":"eyepetizer://tag/384/?title=%E6%97%A5%E6%9C%AC%E5%B9%BF%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/1bff9414303805e74affe1954f95d4af.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/40036ba884aed65c07a5ed1525e6cb2a.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"},{"id":146,"name":"666","actionUrl":"eyepetizer://tag/146/?title=666","adTrack":null,"desc":null,"bgPicture":"https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg","headerImage":"http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"}]
         * consumption : {"collectionCount":96,"shareCount":66,"replyCount":2}
         * resourceType : video
         * slogan : 是什么让你还没上班就想下班？
         * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
         * category : 广告
         * author : {"id":2162,"icon":"http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg","name":"开眼广告精选","description":"为广告人的精彩创意点赞","link":"","latestReleaseTime":1522630800000,"videoNum":902,"adTrack":null,"follow":{"itemType":"author","itemId":2162,"followed":false},"shield":{"itemType":"author","itemId":2162,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true}
         * cover : {"feed":"http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/2f18bf5aaa276c713c2d6d54e6fab536.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=default&source=aliyun
         * thumbPlayUrl : null
         * duration : 132
         * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=94059","forWeibo":"http://www.eyepetizer.net/detail.html?vid=94059"}
         * releaseTime : 1522630800000
         * playInfo : [{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun","size":7391877},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=qcloud","size":7391877},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=ucloud","size":7391877}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=aliyun","size":13630627},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=qcloud","size":13630627},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=ucloud","size":13630627}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=aliyun"}]
         * campaign : null
         * waterMarks : null
         * adTrack : null
         * type : NORMAL
         * titlePgc : null
         * descriptionPgc : null
         * remark : ビジネス帰宅部｜帰宅スキルを駆使して定時で帰る 「帰り方改革」推進中！
         * ifLimitVideo : false
         * idx : 0
         * shareAdTrack : null
         * favoriteAdTrack : null
         * webAdTrack : null
         * date : 1522630800000
         * promotion : null
         * label : null
         * labelList : []
         * descriptionEditor : 以按时回家为目的的「回家改革部」今日建成，各式招数帮你解除加班魔咒！手段是另一回事，最重要的是要有一个回家的理由啊～让你还未上班就想下班的动力又是什么呢？From KDDI株式会社
         * collected : false
         * played : false
         * subtitles : []
         * lastViewTime : null
         * playlists : null
         * src : null
         */

        var data: Data? = null
        var tag: String? = null
        var id: Int = 0
        var adIndex: Int = 0

        class Data {
            var dataType: String? = null
            var id: Int = 0
            var title: String? = null
            var description: String? = null
            var library: String? = null
            /**
             * collectionCount : 96
             * shareCount : 66
             * replyCount : 2
             */

            var consumption: Consumption? = null
            var resourceType: String? = null
            var slogan: String? = null
            /**
             * name : YouTube
             * alias : youtube
             * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
             */

            var provider: Provider? = null
            var category: String? = null
            /**
             * id : 2162
             * icon : http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg
             * name : 开眼广告精选
             * description : 为广告人的精彩创意点赞
             * link :
             * latestReleaseTime : 1522630800000
             * videoNum : 902
             * adTrack : null
             * follow : {"itemType":"author","itemId":2162,"followed":false}
             * shield : {"itemType":"author","itemId":2162,"shielded":false}
             * approvedNotReadyVideoCount : 0
             * ifPgc : true
             */

            var author: Author? = null
            /**
             * feed : http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg
             * detail : http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg
             * blurred : http://img.kaiyanapp.com/2f18bf5aaa276c713c2d6d54e6fab536.jpeg?imageMogr2/quality/60/format/jpg
             * sharing : null
             * homepage : http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
             */

            var cover: Cover? = null
            var playUrl: String? = null
            var thumbPlayUrl: Any? = null
            var duration: Int = 0
            /**
             * raw : http://www.eyepetizer.net/detail.html?vid=94059
             * forWeibo : http://www.eyepetizer.net/detail.html?vid=94059
             */

            var webUrl: WebUrl? = null
            var releaseTime: Long = 0
            var campaign: Any? = null
            var waterMarks: Any? = null
            var adTrack: Any? = null
            var type: String? = null
            var titlePgc: Any? = null
            var descriptionPgc: Any? = null
            var remark: String? = null
            var isIfLimitVideo: Boolean = false
            var idx: Int = 0
            var shareAdTrack: Any? = null
            var favoriteAdTrack: Any? = null
            var webAdTrack: Any? = null
            var date: Long = 0
            var promotion: Any? = null
            var label: Any? = null
            var descriptionEditor: String? = null
            var isCollected: Boolean = false
            var isPlayed: Boolean = false
            var lastViewTime: Any? = null
            var playlists: Any? = null
            var src: Any? = null
            /**
             * id : 748
             * name : 广告精选
             * actionUrl : eyepetizer://tag/748/?title=%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89
             * adTrack : null
             * desc : null
             * bgPicture : http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg
             * headerImage : http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg
             * tagRecType : IMPORTANT
             */

            var tags: List<Tags>? = null
            /**
             * height : 480
             * width : 854
             * urlList : [{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun","size":7391877},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=qcloud","size":7391877},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=ucloud","size":7391877}]
             * name : 标清
             * type : normal
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun
             */

            var playInfo: List<PlayInfo>? = null
            var labelList: List<*>? = null
            var subtitles: List<*>? = null

            class Consumption {
                var collectionCount: Int = 0
                var shareCount: Int = 0
                var replyCount: Int = 0
            }

            class Provider {
                var name: String? = null
                var alias: String? = null
                var icon: String? = null
            }

            class Author {
                var id: Int = 0
                var icon: String? = null
                var name: String? = null
                var description: String? = null
                var link: String? = null
                var latestReleaseTime: Long = 0
                var videoNum: Int = 0
                var adTrack: Any? = null
                /**
                 * itemType : author
                 * itemId : 2162
                 * followed : false
                 */

                var follow: Follow? = null
                /**
                 * itemType : author
                 * itemId : 2162
                 * shielded : false
                 */

                var shield: Shield? = null
                var approvedNotReadyVideoCount: Int = 0
                var isIfPgc: Boolean = false

                class Follow {
                    var itemType: String? = null
                    var itemId: Int = 0
                    var isFollowed: Boolean = false
                }

                class Shield {
                    var itemType: String? = null
                    var itemId: Int = 0
                    var isShielded: Boolean = false
                }
            }

            class Cover {
                var feed: String? = null
                var detail: String? = null
                var blurred: String? = null
                var sharing: Any? = null
                var homepage: String? = null
            }

            class WebUrl {
                var raw: String? = null
                var forWeibo: String? = null
            }

            class Tags {
                var id: Int = 0
                var name: String? = null
                var actionUrl: String? = null
                var adTrack: Any? = null
                var desc: Any? = null
                var bgPicture: String? = null
                var headerImage: String? = null
                var tagRecType: String? = null
            }

            class PlayInfo {
                var height: Int = 0
                var width: Int = 0
                var name: String? = null
                var type: String? = null
                var url: String? = null
                /**
                 * name : aliyun
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun
                 * size : 7391877
                 */

                var urlList: List<UrlList>? = null

                class UrlList {
                    var name: String? = null
                    var url: String? = null
                    var size: Int = 0
                }
            }
        }
    }
}

