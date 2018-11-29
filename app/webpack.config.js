const KotlinWebpackPlugin = require('@jetbrains/kotlin-webpack-plugin');

const BUILD_MODE = process.env.NODE_ENV || 'production';
// const IS_DEVEROPMENT = BUILD_MODE === 'development';

module.exports = {
    mode: BUILD_MODE,
    entry: {
        "MyProduct": __dirname + '/js/index.js'
    },
    plugins: [
        new KotlinWebpackPlugin({
            src: __dirname + '/kt',
            output: 'js',
            optimize: false,
            moduleName: 'MyProductKt', // ビルド時のJSファイル名
            moduleKind: 'commonjs',
            librariesAutoLookup: true,
            verbose: true,
        })
    ]
};