<template>
    <v-container>
        <v-layout>
            <v-flex xs5>
                <div class="title mb-3">User profile</div>
                <v-layout>
                    <v-flex class="px-1">
                        <img :src="profile.userpic"></img>
                    </v-flex>
                    <v-flex class="px-1">
                        <v-layout column>
                        <v-flex>{{profile.name}}</v-flex>
                        <v-flex>{{profile.locale}}</v-flex>
                        <v-flex>{{profile.gender}}</v-flex>
                        <v-flex>{{profile.email}}</v-flex>
                        <v-flex>{{profile.lastVisit}}</v-flex>
                        </v-layout>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import { mapState } from 'vuex'
    export default {
        name: 'Profile',
        computed: mapState(['profile'])
    }
</script>

<style scoped>
img {
        max-width: 150px;
        height: auto;
    }
</style>