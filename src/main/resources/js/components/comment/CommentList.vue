<template>
    <v-list three-line>
        <v-subheader>
            Comments
        </v-subheader>
        <template
            v-for="(item, index) in sortedList"
        >
            <v-divider
                 v-if="index > 0"
                 :key="index"
            ></v-divider>
            <comment-item
                    :comment="item"
                    :key="'item' + index"
            ></comment-item>
        </template>
        <comment-form :message-id="messageId"></comment-form>
    </v-list>
</template>
<script>
    import CommentForm from './CommentForm.vue'
    import CommentItem from './CommentItem.vue'
    export default {
        name: 'CommentList',
        components: {CommentForm, CommentItem},
        props: ['comments', 'messageId'],
        computed: {
            sortedList () {
                if (this.comments == null) return this.comments
                return this.comments.sort((a, b) => (a.id - b.id))
            }
        }
    }
</script>
<style scoped>
</style>